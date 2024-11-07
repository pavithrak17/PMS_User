import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css'; // FontAwesome for icons

const Navbar = () => {
    const [isActive, setIsActive] = useState(false);
    const [searchQuery, setSearchQuery] = useState('');
    const navigate = useNavigate(); // Use navigate for redirection

    const toggleMenu = () => {
        setIsActive(!isActive);
    };

    const handleSearchChange = (event) => {
        setSearchQuery(event.target.value);
    };

    const handleSearchSubmit = (event) => {
        event.preventDefault();
        navigate(`/users?search=${searchQuery}`); // Redirect to user list with search query
    };

    return (
        <nav className="navbar">
            <h2>Placement Management System</h2>
            <div className="navbar-toggle" onClick={toggleMenu}>
                <i className={`fas fa-${isActive ? 'times' : 'bars'}`}></i>
            </div>
            <div className={`navbar-links ${isActive ? 'active' : ''}`}>
                <Link to="/"><i className="fas fa-home"></i> Home</Link>
                <Link to="/about"><i className="fas fa-info-circle"></i> About</Link>
                <Link to="/contact"><i className="fas fa-envelope"></i> Contact</Link>
                <Link to="/users"><i className="fas fa-users"></i> List</Link>
                <Link to="/adduser"><i className="fas fa-user-plus"></i> Add User</Link>
            </div>
            <form className="navbar-search" onSubmit={handleSearchSubmit}>
                <input 
                    type="text" 
                    placeholder="Search by name..." 
                    value={searchQuery} 
                    onChange={handleSearchChange} 
                />
                <button type="submit">
                    <i className="fas fa-search"></i> {/* Search icon */}
                </button>
            </form>
        </nav>
    );
};

export default Navbar;
