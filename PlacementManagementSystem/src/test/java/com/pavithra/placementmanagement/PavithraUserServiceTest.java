package com.pavithra.placementmanagement;

// Import necessary classes for testing
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Indicate that this class is a Spring Boot test
@SpringBootTest
// Specify the order in which the tests should be executed
@TestMethodOrder(OrderAnnotation.class)
public class PavithraUserServiceTest {

    @Autowired
    private PavithraUserService userService; // Inject the user service for testing

    @MockBean
    private PavithraUserRepository userRepository; // Mock the user repository to simulate database operations

    private PavithraUser user1; // Test user object 1
    private PavithraUser user2; // Test user object 2

    // Setup method to initialize test data before each test
    @BeforeEach
    void setUp() {
        // Initialize test users
        user1 = new PavithraUser(1, "User1", "Admin", "password1", "user1@example.com", "1234567890", true);
        user2 = new PavithraUser(2, "User2", "User", "password2", "user2@example.com", "0987654321", false);

        // Create a list of users to mock the repository's return value
        List<PavithraUser> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // Mock the repository methods to return predefined values
        when(userRepository.findAll()).thenReturn(users); // Mock findAll to return the list of users
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user1)); // Mock findById for user1
        when(userRepository.findById(2)).thenReturn(java.util.Optional.of(user2)); // Mock findById for user2
        when(userRepository.save(any(PavithraUser.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Mock save to return the saved user
        when(userRepository.existsById(1)).thenReturn(true); // Mock existsById for user1
        when(userRepository.existsById(2)).thenReturn(false); // User with ID 2 doesn't exist for update
    }

    // Test case to verify retrieval of all users
    @Test
    @Order(1)
    public void testGetAllUsers() {
        List<PavithraUser> users = userService.getAllUsers(); // Call the method to get all users
        assertEquals(2, users.size()); // Assert that the size of the returned list is 2
    }

    // Test case to verify retrieval of a user by ID
    @Test
    @Order(2)
    public void testGetUserById() {
        PavithraUser user = userService.getUserById(1); // Call the method to get user1 by ID
        assertNotNull(user); // Assert that the user is not null
        assertEquals("User1", user.getName()); // Assert that the user's name is as expected
    }

    // Test case to verify adding a new user
    @Test
    @Order(3)
    public void testAddUser() {
        PavithraUser newUser = new PavithraUser(null, "User3", "User", "password3", "user3@example.com", "1122334455", true); // Create a new user
        PavithraUser createdUser = userService.addUser(newUser); // Call the method to add the user
        
        assertNotNull(createdUser); // Assert that the created user is not null
        assertEquals("User3", createdUser.getName()); // Assert that the user's name is as expected
    }

    // Test case to verify updating an existing user
    @Test
    @Order(4)
    public void testUpdateUser() {
        PavithraUser updatedUser = new PavithraUser(1, "UpdatedUser1", "Admin", "newpassword1", "updateduser1@example.com", "1111111111", true); // Create an updated user
        PavithraUser result = userService.updateUser(updatedUser); // Call the method to update the user
        
        assertNotNull(result); // Assert that the updated user is not null
        assertEquals("UpdatedUser1", result.getName()); // Assert that the updated user's name is as expected
    }

    // Test case to verify deleting a user
    @Test
    @Order(5)
    public void testDeleteUser() {
        assertNotNull(userService.getUserById(2)); // Ensure that user with ID 2 exists before deletion

        // Perform the delete operation
        userService.deleteUser(2);

        // After deletion, simulate that the user is no longer found
        when(userRepository.findById(2)).thenReturn(java.util.Optional.empty()); // Mock the findById to return empty for deleted user

        // Assert that the user no longer exists
        assertNull(userService.getUserById(2)); // Assert that the user with ID 2 is null after deletion
    }
}
