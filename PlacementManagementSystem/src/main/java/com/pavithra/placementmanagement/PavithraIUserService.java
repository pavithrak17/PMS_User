package com.pavithra.placementmanagement;

import java.util.List;

// Interface defining the contract for user-related services in the placement management system.
public interface PavithraIUserService {
    
    // Method to retrieve all users from the system.
    List<PavithraUser> getAllUsers();
    
    // Method to retrieve a user by their unique identifier (ID).
    PavithraUser getUserById(Integer id);
    
    // Method to add a new user to the system.
    PavithraUser addUser(PavithraUser user); // Returns the added user.
    
    // Method to delete a user from the system by their unique identifier (ID).
    void deleteUser(Integer id);
    
    // Method to update an existing user's details in the system.
    PavithraUser updateUser(PavithraUser user); // Returns the updated user.
}
