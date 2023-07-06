package com.example.user_manager.service;

import com.example.user_manager.dto.*;
import com.example.user_manager.entity.DepartmentEntity;
import com.example.user_manager.repository.DepartmentRepository;
import com.example.user_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream().map(
                dep -> new DepartmentDto(dep)
        ).collect(Collectors.toList());
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Can't find department")
        );
    }

    public DepartmentEntity addNewDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }
}
