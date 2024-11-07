import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import axios from 'axios';
import Navbar from './components/Navbar';
import UserForm from './components/UserForm';
import UserList from './components/UserList';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import Footer from './components/Footer'; // Corrected path

import './styles.css';

const App = () => {
    const [selectedUser, setSelectedUser] = useState(null);

    const handleEdit = (user) => {
        setSelectedUser(user);
    };

    const handleFormSubmit = async (id, userData) => {
        try {
            if (id) {
                // Update existing user
                await axios.put(`http://localhost:8084/user/${id}`, userData);
            } else {
                // Add new user
                await axios.post('http://localhost:8084/user', userData);
            }
            setSelectedUser(null); // Reset selected user
        } catch (error) {
            console.error("Error submitting user data:", error);
        }
    };

    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />   
                <Route path="/adduser" element={
                    <>
                        <UserForm user={selectedUser} onFormSubmit={handleFormSubmit} />
                    </>
                } />
                <Route path="/users" element={
                    <>
                        <UserList onEdit={handleEdit} />
                    </>
                } />
                <Route path="/about" element={<About/>} />
                <Route path="/contact" element={<Contact/>} />
            </Routes>
            <Footer /> {/* Moved Footer outside of Routes to display it on all pages */}
        </Router>
    );
};

export default App;
