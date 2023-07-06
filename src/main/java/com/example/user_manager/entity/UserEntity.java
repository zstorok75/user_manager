package com.example.user_manager.entity;

import com.example.user_manager.dto.NewUserDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "APP_USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column( name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentEntity department;

    @Column( name = "BIRTHDAY")
    private LocalDate birthday;

    /*************************************************** CONSTRUCTOR ***************************************************/

    public UserEntity() {}

    public UserEntity(NewUserDto newUserDto) {
        this.name = newUserDto.getName();
        this.birthday = newUserDto.getBirthday();
    }

    /************************************************** GETTER SETTER **************************************************/

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getDepartment() {
        return this.department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

}
