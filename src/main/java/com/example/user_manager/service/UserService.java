package com.example.user_manager.service;

import com.example.user_manager.dto.NewUserDto;
import com.example.user_manager.dto.UserDto;
import com.example.user_manager.entity.DepartmentEntity;
import com.example.user_manager.entity.UserEntity;
import com.example.user_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final DepartmentService departmentService;

    public UserService(UserRepository userRepository, DepartmentService departmentService) {
        this.userRepository = userRepository;
        this.departmentService = departmentService;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(
                (e) -> { return new UserDto(e); }
        ).collect(Collectors.toList());
    }

    public void addNewUser(NewUserDto userDto) {
        UserEntity user = new UserEntity(userDto);
        DepartmentEntity department;
        if (userDto.getDepartment().getId() == null) {
            DepartmentEntity dep = new DepartmentEntity(userDto.getDepartment().getName());
            department = departmentService.addNewDepartment(dep);
        } else {
            department = departmentService.getDepartmentById(userDto.getDepartment().getId());
        }
        user.setDepartment(department);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
