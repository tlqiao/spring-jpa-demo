package com.example.springjpademo.mybatisdemo.service;

import com.example.springjpademo.mybatisdemo.dao.Coffee;
import com.example.springjpademo.mybatisdemo.mapper.CoffeeMapper;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeService {

    @Autowired
    CoffeeMapper coffeeMapper;

    public void addFindCoffee() {
      Coffee coffee =  Coffee.builder()
                .name("natie")
                .price(Money.of(CurrencyUnit.of("CNY"),100))
                .build();
        coffeeMapper.save(coffee);
       Coffee c= coffeeMapper.findCoffeeById(coffee.getId());
       System.out.println("--find coffee with mybatis--");
       System.out.println(c);
    }

}
