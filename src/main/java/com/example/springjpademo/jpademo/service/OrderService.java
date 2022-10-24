package com.example.springjpademo.jpademo.service;

import com.example.springjpademo.jpademo.model.Coffee;
import com.example.springjpademo.jpademo.model.CoffeeOrder;
import com.example.springjpademo.jpademo.model.OrderState;
import com.example.springjpademo.jpademo.repository.CoffeeOrderRepository;
import com.example.springjpademo.jpademo.repository.CoffeeRepository;
import org.h2.util.DateTimeUtils;
import org.hibernate.criterion.Order;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
@Component
public class OrderService {
    @Autowired
    CoffeeRepository coffeeRepository;
    @Autowired
    CoffeeOrderRepository coffeeOrderRepository;

    public void addCoffee(){
       Coffee one= Coffee.builder()
                .name("natie")
                .price(Money.of(CurrencyUnit.of("CNY"),100))
                .build();
        coffeeRepository.save(one);

        Coffee two= Coffee.builder()
                .name("motie")
                .price(Money.of(CurrencyUnit.of("CNY"),20))
                .build();
        coffeeRepository.save(two);

        CoffeeOrder order1=CoffeeOrder.builder()
                .name("zhangshan")
                .items(Collections.singletonList(one))
                .state(OrderState.BREWING)
                .build();
        coffeeOrderRepository.save(order1);
    }

    public void coffeeQueryByName(String name) {
      Coffee coffee=  coffeeRepository.findByName(name);
      System.out.println(coffee);
    }

    public void countByName(String name) {
          int number = coffeeRepository.countByName(name);
          System.out.println(number);
    }

    public void findTop3Coffee(){
       List<Coffee> coffeeList = coffeeRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
       System.out.println("--the top3 coffee list is---");
       coffeeList.forEach(item-> System.out.println(item));
    }

    public void findTop3CoffeeOrder(){
        List<CoffeeOrder> coffeeOrderList = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
       System.out.println("--the top3 coffee order list is---");
        coffeeOrderList.forEach(item -> System.out.println(item));
    }

    public void findByItemsName( String name) {
       List<CoffeeOrder> coffeeOrderList = coffeeOrderRepository.findByItems_Name(name);
       System.out.println("--find coffee order list by name---");
       coffeeOrderList.forEach(item-> System.out.println(item));

    }
}
