package com.example.springjpademo.jpademo.repository;

import com.example.springjpademo.jpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Long>{
    List<User> findUserByDepartmentName(String name);

    // 原生查询方式获取user信息，原生查询直接查询数据库的表，不同的数据库语法可能略有不同
    @Query(value = "select * from t_user u where u.name=?1", nativeQuery = true)
    User findUserByUserName(String name);

    @Query(value="select u from User u where u.name=:name")
    User findUserByName(@Param("name") String name);
}
