package com.example.springjpademo.mybatisdemo.service;

import com.example.springjpademo.mybatisdemo.dao.Student;
import com.example.springjpademo.mybatisdemo.dao.Teacher;
import com.example.springjpademo.mybatisdemo.dao.Class;
import com.example.springjpademo.mybatisdemo.mapper.ClassMapper;
import com.example.springjpademo.mybatisdemo.mapper.JoinMapper;
import com.example.springjpademo.mybatisdemo.mapper.StudentMapper;
import com.example.springjpademo.mybatisdemo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataService {
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    JoinMapper joinMapper;

    public void addClassStudentTeacher() {
        Teacher teacherOne = Teacher.builder()
                .name("teacherWang")
                .build();
        teacherMapper.save(teacherOne);

        Teacher teacherTwo = Teacher.builder()
                .name("teacherWang")
                .build();
        teacherMapper.save(teacherTwo);

        Class classEnglish = Class.builder()
                .name("classEnglish")
                .teacherId(1)
                .build();
        classMapper.save(classEnglish);

        Class classMath = Class.builder()
                .name("classEnglish")
                .teacherId(2)
                .build();
        classMapper.save(classMath);

        Student student = Student.builder()
                .name("taoli")
                .classId(1)
                .build();
        studentMapper.save(student);

        student = Student.builder()
                .name("wangwu")
                .classId(1)
                .build();
        studentMapper.save(student);

        student = Student.builder()
                .name("zhangsan")
                .classId(1)
                .build();
        studentMapper.save(student);

        student = Student.builder()
                .name("lisi")
                .classId(2)
                .build();
        studentMapper.save(student);

        student = Student.builder()
                .name("mazi")
                .classId(2)
                .build();
        studentMapper.save(student);
    }

    public void queryData() {
        joinMapper.joinAll();
        Student student = studentMapper.findStudentById(1);
        System.out.println("--studentname is-- " + student.getName() + "--className is-- " + student.getMyClass().getName());


        List<Student> studentList = studentMapper.findStudentsByClassId(1);
        studentList.forEach(item -> {
            System.out.println("--student name is --" + item.getName());
            System.out.println("--student's class name is-- " + item.getMyClass().getName());
        });

        Teacher teacher = teacherMapper.findTeacherById(1);
        System.out.println("--teacherName is --" + teacher.getName() + "--className is --" + teacher.getClass().getName());
        List<Class> classList = classMapper.getClassByTeacherId(1);
        classList.forEach(item -> {
            System.out.println(item.getTeacher().getName());
        });

    }
}
