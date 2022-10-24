package com.example.springjpademo.mybatisdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
private Integer id;
private String name;
private Integer classId;
private Class myClass;
}
