package com.example.springjpademo;

import com.example.springjpademo.multipledb.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void testMysqlDB() {
        personRepository.getPersonCountFromMysql();
    }

//    @Test
//    public void testH2DB() {
//        personRepository.getPersonCountFromH2();
//    }
}
