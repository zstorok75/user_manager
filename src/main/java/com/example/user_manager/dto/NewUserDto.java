package com.example.user_manager.dto;

import java.time.LocalDate;
public class NewUserDto {

    private String name;
    private NewDepartmentDto department;

    private LocalDate birthday;

    /*************************************************** CONSTRUCTOR ***************************************************/

    public NewUserDto(String name, LocalDate birthday, NewDepartmentDto department) {
        this.name = name;
        this.birthday = birthday;
        this.department = department;
    }

    /***************************************************** GETTER *****************************************************/

    public String getName() {
        return name;
    }

    public void setDepartment(NewDepartmentDto department) {
        this.department = department;
    }

    public NewDepartmentDto getDepartment() {
        return department;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
