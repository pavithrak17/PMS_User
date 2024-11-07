// About.js
import React from 'react';

const About = () => {
    return (
        <div className="about">
            <h1>About </h1>
            <p>
                This system provides features for users to manage placements efficiently. Users can view and apply for 
                job postings, while admins can manage user data and update placement statuses.
            </p>
            <ul>
                <li><strong>Students:</strong> Apply for job postings, view placement history.</li>
                <li><strong>Admins:</strong> Manage job postings, track student applications, update placement details.</li>
            </ul>
        </div>
    );
};

export default About;
