package com.usm.taskmanagement.controller;

import com.usm.taskmanagement.integration.UserManagementService;
import com.usm.taskmanagement.integration.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserManagementService service;

    @GetMapping(value = "/task-manager/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

}
