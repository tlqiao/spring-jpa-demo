package com.example.springjpademo.mybatisdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Class implements Serializable {
private Integer id;
private String name;
private Integer teacherId;
private Teacher teacher;
//private List<Student> students;
}
