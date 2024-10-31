package com.pavithra.placementmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indicates that this class is a REST controller.
@RequestMapping("/user") // Maps requests to /user to this controller.
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true") // Allows cross-origin requests from the specified origin.
public class PavithraUserController {

    @Autowired
    private PavithraUserService service; // Injects the user service for handling user-related operations.

    // Handles GET requests to /user and returns a list of all users.
    @GetMapping
    public List<PavithraUser> listAll() {
        return service.getAllUsers(); // Fetch and return all users from the service.
    }

    // Handles GET requests to /user/{id} to retrieve a specific user by their ID.
    @GetMapping("/{id}")
    public ResponseEntity<PavithraUser> getUser(@PathVariable Integer id) {
        PavithraUser user = service.getUserById(id); // Retrieve the user by ID.
        // Return the user if found, otherwise return a 404 Not Found response.
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Handles POST requests to /user to create a new user.
    @PostMapping
    public ResponseEntity<PavithraUser> addUser(@RequestBody PavithraUser user) {
        PavithraUser createdUser = service.addUser(user); // Add the user via the service.
        return ResponseEntity.ok(createdUser); // Return the created user.
    }

    // Handles PUT requests to /user/{id} to update an existing user.
    @PutMapping("/{id}")
    public ResponseEntity<PavithraUser> updateUser(@PathVariable Integer id, @RequestBody PavithraUser user) {
        if (service.getUserById(id) != null) { // Check if the user exists.
            user.setId(id); // Set the user ID for the update.
            PavithraUser updatedUser = service.updateUser(user); // Update the user via the service.
            return ResponseEntity.ok(updatedUser); // Return the updated user.
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the user does not exist.
        }
    }

    // Handles DELETE requests to /user/{id} to delete a specific user by their ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        service.deleteUser(id); // Delete the user via the service.
        return ResponseEntity.noContent().build(); // Return 204 No Content response.
    }
}
