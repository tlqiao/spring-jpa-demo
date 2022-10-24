package com.example.springjpademo;

import com.example.springjpademo.mybatisdemo.service.CoffeeService;
import com.example.springjpademo.mybatisdemo.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springjpademo.mybatisdemo.mapper")
@Slf4j
public class MybatisDemoApplication implements ApplicationRunner {
    @Autowired
    CoffeeService coffeeService;
    @Autowired
    DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args){
//      coffeeService.addFindCoffee();
//        System.out.println("--add class user teacher--");
//        dataService.addClassStudentTeacher();
        System.out.println("--query data with mybatis--");
        dataService.queryData();
    }
}
