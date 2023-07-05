package com.example.user_manager.controller;

import com.example.user_manager.dto.DepartmentDto;
import com.example.user_manager.dto.NewUserDto;
import com.example.user_manager.dto.UserDto;
import com.example.user_manager.service.DepartmentService;
import com.example.user_manager.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final DepartmentService departmentService;

    public UserController(UserService userService, DepartmentService departmentService) {
        this.userService = userService;
        this.departmentService = departmentService;
    };

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addNewUser(@RequestBody NewUserDto newUser) {
        try {
            userService.addNewUser(newUser);
        } catch ( IllegalStateException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> findAllDepartments() {
        List<DepartmentDto> departments = departmentService.getDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<Void> deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
