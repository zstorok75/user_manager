package com.example.user_manager.dto;

import java.util.List;

public class FillUpDatabaseDto {

    public List<DepartmentForDatabaseDto> departments;

    public FillUpDatabaseDto() {}

    public FillUpDatabaseDto(List<DepartmentForDatabaseDto> departments) {
        this.departments = departments;
    }

    public List<DepartmentForDatabaseDto> getDepartments() {
        return departments;
    }
}
