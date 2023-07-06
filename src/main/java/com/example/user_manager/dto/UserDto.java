package com.example.user_manager.dto;

import com.example.user_manager.entity.UserEntity;

import java.time.LocalDate;

public class UserDto {

    private Long id;
    private DepartmentDto department;
    private String name;
    private LocalDate birthday;

    /*************************************************** CONSTRUCTOR ***************************************************/

    public UserDto() {}

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.department = new DepartmentDto(user.getDepartment());
        this.birthday = user.getBirthday();
    }

    /***************************************************** GETTER *****************************************************/

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentDto getDepartment() {
        return this.department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}