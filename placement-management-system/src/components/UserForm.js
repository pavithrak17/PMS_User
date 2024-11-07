import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import userImage from '../images/pavi.webp';

const UserForm = ({ user, onFormSubmit }) => {
    const [id, setid] = useState('');
    const [name, setName] = useState('');
    const [role, setRole] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [contactNumber, setContactNumber] = useState('');
    const [status, setStatus] = useState(true);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);
    const [successMessage, setSuccessMessage] = useState(''); // State for success message

    const navigate = useNavigate(); // Hook for navigation

    useEffect(() => {
        if (user) {
            setid(user.id);
            setName(user.name);
            setRole(user.role);
            setEmail(user.email);
            setPassword(user.password);
            setContactNumber(user.contactNumber);
            setStatus(user.status);
        } else {
            setid('');
            setName('');
            setRole('');
            setEmail('');
            setPassword('');
            setContactNumber('');
            setStatus(true);
        }
    }, [user]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const userData = { id, name, role, email, password, contactNumber, status };
        setLoading(true);

        try {
            await onFormSubmit(user ? user.id : null, userData);
            setError(null);
            setSuccessMessage(user ? 'User updated successfully!' : 'User added successfully!'); // Set success message
            setTimeout(() => {
                navigate('/users'); // Redirect after a short delay
            }, 1500); // Adjust time as needed
        } catch (error) {
            setError("An error occurred while submitting the form. Please try again.");
        } finally {
            setLoading(false);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            {/* User Icon and Image at the Top */}
            <div className="user-image">
                <img src={userImage} alt="User Icon" className="user-profile-img" />
            </div>

            {error && <p className="error">{error}</p>}
            {successMessage && <p className="success">{successMessage}</p>} {/* Display success message */}
            
            <input 
                type="text" 
                placeholder="ID" 
                value={id} 
                onChange={(e) => setid(e.target.value)} 
                required 
            />
            <input 
                type="text" 
                placeholder="Name" 
                value={name} 
                onChange={(e) => setName(e.target.value)} 
                required 
            />
            <input 
                type="text" 
                placeholder="Role" 
                value={role} 
                onChange={(e) => setRole(e.target.value)} 
                required 
            />
            <input 
                type="email" 
                placeholder="Email" 
                value={email} 
                onChange={(e) => setEmail(e.target.value)} 
                required 
            />
            <input 
                type="text" 
                placeholder="Contact Number" 
                value={contactNumber} 
                onChange={(e) => setContactNumber(e.target.value)} 
                required 
            />
            <input 
                type="password" 
                placeholder="Password" 
                value={password} 
                onChange={(e) => setPassword(e.target.value)} 
                required 
            />
            
            <label>
                <input 
                    type="checkbox" 
                    checked={status} 
                    onChange={(e) => setStatus(e.target.checked)} 
                />
                Active
            </label>
            <button type="submit" disabled={loading}>
                {loading ? 'Submitting...' : (user ? 'Update' : 'Add User')}
            </button>
        </form>
    );
};

export default UserForm;
