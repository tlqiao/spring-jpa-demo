package com.example.springjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionApplication {
    public void main(String [] args) {
        SpringApplication.run(TransactionApplication.class,args);
    }
}
