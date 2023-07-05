package com.example.user_manager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "DEPARTMENT")
public class DepartmentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID")
    private Long id;

    @Column( name = "NAME")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<UserEntity> users;

    /*************************************************** CONSTRUCTOR ***************************************************/

    public DepartmentEntity() {};
    public DepartmentEntity(String departmentName) {
        this.name = departmentName;
    }

    /***************************************************** GETTER *****************************************************/

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
