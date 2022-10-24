package com.example.springjpademo;

import com.example.springjpademo.jpademo.service.OrderService;
import com.example.springjpademo.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class JPADemoApplication implements ApplicationRunner {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    public static void main(String[] args){
        SpringApplication.run(JPADemoApplication.class,args);
    }
    @Override
    @Transactional
    public void run(ApplicationArguments  args) {
//        orderService.addCoffee();
//        orderService.countByName("natie");
//        orderService.coffeeQueryByName("natie");
//        orderService.findTop3Coffee();
//        orderService.findTop3CoffeeOrder();
//        orderService.findByItemsName("natie");
//          userService.addDepartmentAndUser();
//          userService.findUserListByDepartment();
//          userService.findUserByName();
//          userService.findUserByNameAndAge();
    }
}
