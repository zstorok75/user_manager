package com.example.user_manager.dto;

import com.example.user_manager.entity.DepartmentEntity;

public class DepartmentDto {

    private Long id;

    private String name;


    public DepartmentDto(DepartmentEntity department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
