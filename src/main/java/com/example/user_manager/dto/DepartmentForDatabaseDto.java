package com.example.user_manager.dto;

import java.util.List;

public class DepartmentForDatabaseDto {

    private String name;
    private List<NewUserDto> users;

    public DepartmentForDatabaseDto(String name, List<NewUserDto> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<NewUserDto> getUsers() {
        return users;
    }
}
