// UserList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, useLocation } from 'react-router-dom';

const UserList = ({ onEdit }) => {
    const [users, setUsers] = useState([]);
    const [error, setError] = useState(null); // Error state
    const navigate = useNavigate();
    const location = useLocation();

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        try {
            const response = await axios.get('http://localhost:8084/user');
            setUsers(response.data);
            setError(null); // Reset error on success
        } catch (error) {
            setError("An error occurred while fetching users."); // Set error message
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8084/user/${id}`);
            fetchUsers(); // Refresh user list after deletion
            setError(null); // Reset error on success
        } catch (error) {
            setError("An error occurred while deleting the user."); // Set error message
        }
    };

    const handleEdit = (user) => {
        onEdit(user); // Set the user to edit
        navigate('/adduser'); // Navigate to the form page
    };

    // Filter users based on the search query from URL
    const searchParams = new URLSearchParams(location.search);
    const searchQuery = searchParams.get('search')?.toLowerCase();

    const filteredUsers = searchQuery
        ? users.filter(user => user.name.toLowerCase().includes(searchQuery))
        : users;

    return (
        <div>
            {error && <p className="error">{error}</p>} {/* Display error message */}
            <h2>User List</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Contact Number</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {filteredUsers.map(user => (
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.role}</td>
                            <td>{user.email}</td>
                            <td>{user.password}</td>
                            <td>{user.contactNumber}</td>
                            <td>{user.status ? 'Active' : 'Inactive'}</td>
                            <td>
                                <button onClick={() => handleEdit(user)}>
                                    <i className="fas fa-edit"></i> {/* Edit icon */}
                                </button>
                                <button onClick={() => handleDelete(user.id)}>
                                    <i className="fas fa-trash"></i> {/* Delete icon */}
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default UserList;
