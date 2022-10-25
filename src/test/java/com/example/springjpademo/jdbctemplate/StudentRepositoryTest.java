package com.example.springjpademo.jdbctemplate;

import com.example.springjpademo.jdbctemplate.dao.Student;
import com.example.springjpademo.jdbctemplate.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes={JdbcTemplateApplication.class})
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testGetStudentCount() {
        int number = studentRepository.getCountOfStudent("taoli");
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);
    }

    @Test
    void testAddStudent() {
        Student student = new Student().builder()
				.name("wanger")
				.age(120)
				.address("beijing")
				.postcode("70015")
				.build();
		studentRepository.addStudent(student);
    }

    @Test
    void testUpdateStudent() {
        studentRepository.updateStudent("taoli",300);
    }
    @Test
    void testGetStudentList() {
        studentRepository.getStudentList();
    }

    @Test
    void testBatchAddStudent(){
        studentRepository.addManyStudent();
    }
    @Test
    void testGetSomeStudentList() {
        List<Student> studentList = studentRepository.getSomeStudents(10);
        studentList.forEach(item -> {
            System.out.println(item.getName());
            System.out.println(item.getAge());
        });
    }

    @Test
    void testGetNameByAge(){
      List<String> nameList=  studentRepository.getStudentNameByAge(10);
        nameList.forEach(item -> {System.out.println(item);});
    }

}
