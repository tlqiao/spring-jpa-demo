package com.example.springjpademo.jpademo.service;

import com.example.springjpademo.jpademo.model.Department;
import com.example.springjpademo.jpademo.model.User;
import com.example.springjpademo.jpademo.repository.DepartmentRepository;
import com.example.springjpademo.jpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public void addDepartmentAndUser() {
        Department testDepartment = Department.builder()
                .name("Testing").build();
        Department devDepartment = Department.builder()
                .name("developer").build();

        departmentRepository.save(testDepartment);
        departmentRepository.save(devDepartment);

        User userOne= User.builder()
                .name("taoli")
                .age(10.3)
                .department(testDepartment)
                .build();
        User userThree= User.builder()
                .name("lisi")
                .age(10.3)
                .department(testDepartment)
                .build();

        User userTwo = User.builder()
                .name("wangwu")
                .age(20.0)
                .department(devDepartment).build();
        userRepository.save(userOne);
        userRepository.save(userTwo);
        userRepository.save(userThree);
    }

    public void findUserListByDepartment() {
       List<User> userList = userRepository.findUserByDepartmentName("Testing");
       System.out.println("--Testing department users are ----");
       userList.forEach(item -> System.out.println(item));
    }

    public void findUserByNameAndAge(){
        User user = userRepository.findUserByName("taoli");
        System.out.println(user);
    }

    public void findUserByName() {
        User user = userRepository.findUserByUserName("taoli");
        System.out.println("--find user by user name ----");
        System.out.println(user);
    }
}
