package com.pavithra.placementmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional // Indicates that this class is a service and that its methods should be executed in a transaction context.
public class PavithraUserService implements PavithraIUserService {

    @Autowired
    private PavithraUserRepository repo; // Injecting the user repository for database operations.

    // Retrieves all users from the repository.
    @Override
    public List<PavithraUser> getAllUsers() {
        return repo.findAll(); // Return a list of all users.
    }

    // Retrieves a user by their ID. Returns null if not found.
    @Override
    public PavithraUser getUserById(Integer id) {
        return repo.findById(id).orElse(null); // Find the user by ID and return it if present.
    }

    // Adds a new user to the repository and returns the saved user.
    @Override
    public PavithraUser addUser(PavithraUser user) {
        return repo.save(user); // Save the user and return the saved instance.
    }

    // Deletes a user by their ID.
    @Override
    public void deleteUser(Integer id) {
        repo.deleteById(id); // Remove the user from the repository by ID.
    }

    // Updates an existing user if they exist in the repository. Returns the updated user or null if not found.
    @Override
    public PavithraUser updateUser(PavithraUser user) {
        // Check if the user exists in the repository.
        if (repo.existsById(user.getId())) {
            return repo.save(user); // Save and return the updated user.
        }
        return null; // Return null if the user does not exist.
    }

    // This method appears to be a placeholder for updating a user by ID. 
    // You may want to implement this method for more specific updates.
    public void updateUser(Integer id, PavithraUser user) {
        // TODO Auto-generated method stub
    }
}
