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
public class Teacher implements Serializable {
private Integer id;
private String name;
private List<Class> classList;
}
