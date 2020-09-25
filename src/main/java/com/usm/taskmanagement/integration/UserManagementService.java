package com.usm.taskmanagement.integration;

import com.usm.taskmanagement.integration.client.UserManagerClient;
import com.usm.taskmanagement.integration.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final UserManagerClient client;

    public List<User> getAllUsers() {
        try {
            return client.getUsers().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No connection with service");
        }
    }
}
