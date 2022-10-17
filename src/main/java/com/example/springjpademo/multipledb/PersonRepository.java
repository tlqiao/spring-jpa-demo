package com.example.springjpademo.multipledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    JdbcTemplate mysqlJdbcTemplate;

    @Autowired
    @Qualifier("h2JdbcTemplate")
    JdbcTemplate h2JdbcTemplate;

    public void getPersonCountFromMysql() {
        String sql = "select count(*) from person";
        mysqlJdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void getPersonCountFromH2() {
        String sql = "insert into person values('wang',120)";
        h2JdbcTemplate.update(sql);
        sql = "select count(*) from person";
        h2JdbcTemplate.queryForObject(sql,Integer.class);
    }
}
