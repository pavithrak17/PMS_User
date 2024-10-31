package com.pavithra.placementmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PavithraUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PavithraUserService userService;

    @InjectMocks
    private PavithraUserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void testGetUserById() throws Exception {
        // Arrange
        PavithraUser user = new PavithraUser(1, "User1", "password1", "user1@example.com", "1234567890", "Admin", true);
        when(userService.getUserById(1)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("User1"));
    }

    @Test
    public void testAddUser() throws Exception {
        // Arrange
        PavithraUser user = new PavithraUser(1, "User1", "password1", "user1@example.com", "1234567890", "Admin", true);
        when(userService.addUser(any(PavithraUser.class))).thenReturn(user);

        // Act & Assert
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("User1"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Arrange
        PavithraUser user = new PavithraUser(1, "User1", "password1", "user1@example.com", "1234567890", "Admin", true);
        when(userService.getUserById(1)).thenReturn(user);
        when(userService.updateUser(any(PavithraUser.class))).thenReturn(user);

        // Act & Assert
        mockMvc.perform(put("/user/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("User1"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUser(1);

        // Act & Assert
        mockMvc.perform(delete("/user/{id}", 1))
                .andExpect(status().isNoContent());
    }
}
