package com.example.user_manager.dto;

public class NewDepartmentDto {

    private Long id;
    private String name;

    public NewDepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    };

    public String getName() {
        return this.name;
    };

    public Long getId() {
        return this.id;
    };
}
