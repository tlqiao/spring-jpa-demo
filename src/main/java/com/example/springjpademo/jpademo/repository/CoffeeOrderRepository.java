package com.example.springjpademo.jpademo.repository;
import com.example.springjpademo.jpademo.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByItems_Name(String name);

}
