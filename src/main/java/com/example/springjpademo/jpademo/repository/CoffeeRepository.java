package com.example.springjpademo.jpademo.repository;
import com.example.springjpademo.jpademo.model.Coffee;
import org.joda.money.Money;

import java.util.Date;

public interface CoffeeRepository extends BaseRepository<Coffee,Long> {
    Coffee findByName(String name);
    int countByName(String name);
}
