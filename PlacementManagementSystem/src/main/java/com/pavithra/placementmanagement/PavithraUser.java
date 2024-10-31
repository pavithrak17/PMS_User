package com.pavithra.placementmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Indicates that this class is a JPA entity and will be mapped to a database table.
public class PavithraUser {
    
    @Id // Marks this field as the primary key of the entity.
    private Integer id; // Unique identifier for the user.
    
    private String name; // Name of the user.
    private String role; // Role of the user (e.g., Admin, User).
    private String password; // Password for the user account.
    private String email; // Email address of the user.
    private String contactNumber; // Contact number of the user.
    private boolean status; // Indicates if the user account is active or inactive.

    // Default constructor
    public PavithraUser() {}

    // Parameterized constructor to initialize a user with given values.
    public PavithraUser(Integer id, String name, String role, String password, String email, String contactNumber, boolean status) {
        this.id = id; // Set the user ID.
        this.name = name; // Set the user's name.
        this.role = role; // Set the user's role.
        this.password = password; // Set the user's password.
        this.email = email; // Set the user's email.
        this.contactNumber = contactNumber; // Set the user's contact number.
        this.status = status; // Set the user's status (active/inactive).
    }

    // Getter for the user ID.
    public Integer getId() {
        return id;
    }

    // Setter for the user ID.
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for the user's name.
    public String getName() {
        return name;
    }

    // Setter for the user's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the user's role.
    public String getRole() {
        return role;
    }

    // Setter for the user's role.
    public void setRole(String role) {
        this.role = role;
    }

    // Getter for the user's password.
    public String getPassword() {
        return password;
    }

    // Setter for the user's password.
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for the user's email.
    public String getEmail() {
        return email;
    }

    // Setter for the user's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the user's contact number.
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter for the user's contact number.
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Getter for the user's status (active/inactive).
    public boolean isStatus() {
        return status;
    }

    // Setter for the user's status.
    public void setStatus(boolean status) {
        this.status = status;
    }
}
