package com.pavithra.placementmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PavithraUserTest {

    @Test
    void testConstructorAndGetters() {
        // Create a new PavithraUser object using the parameterized constructor
        PavithraUser user = new PavithraUser(1, "Veena", "Admin", "password123", "veena@example.com", "1234567890", true);

        // Verify the values assigned in the constructor
        assertEquals(1, user.getId());
        assertEquals("Veena", user.getName());
        assertEquals("Admin", user.getRole());
        assertEquals("password123", user.getPassword());
        assertEquals("veena@example.com", user.getEmail());
        assertEquals("1234567890", user.getContactNumber());
        assertTrue(user.isStatus());
    }

    @Test
    void testSetters() {
        // Create a new PavithraUser object using the default constructor
        PavithraUser user = new PavithraUser();

        // Set values using setters
        user.setId(2);
        user.setName("Pavithra");
        user.setRole("User");
        user.setPassword("Pavi1204");
        user.setEmail("pavi@gmail.com");
        user.setContactNumber("9877654321");
        user.setStatus(false);

        // Verify that the values were set correctly
        assertEquals(2, user.getId());
        assertEquals("Pavithra", user.getName());
        assertEquals("User", user.getRole());
        assertEquals("Pavi1204", user.getPassword());
        assertEquals("pavi@gmail.com", user.getEmail());
        assertEquals("9877654321", user.getContactNumber());
        assertFalse(user.isStatus());
    }

    @Test
    void testDefaultConstructor() {
        // Create a new PavithraUser object using the default constructor
        PavithraUser user = new PavithraUser();

        // Verify that default values are null or false as expected
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getRole());
        assertNull(user.getPassword());
        assertNull(user.getEmail());
        assertNull(user.getContactNumber());
        assertFalse(user.isStatus());
    }
}
