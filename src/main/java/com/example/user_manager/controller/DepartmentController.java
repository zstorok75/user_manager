package com.example.user_manager.controller;

import com.example.user_manager.dto.FillUpDatabaseDto;
import com.example.user_manager.dto.UserDto;
import com.example.user_manager.service.DepartmentService;
import com.example.user_manager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {


    private final UserService userService;
    private final DepartmentService departmentService;


    public DepartmentController(UserService userService, DepartmentService departmentService) {
        this.userService = userService;
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addDataToDatabase(@RequestBody FillUpDatabaseDto departments) {
        try {
            departmentService.fillUpDatabase(departments);
        } catch ( IllegalStateException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
