package com.example.springjpademo.redisdemo.service;

import com.example.springjpademo.redisdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisService {
    @Autowired
    RedisTemplate<String , User> redisTemplate;

    public void saveAndGetFromRedis(User user) {
      ValueOperations opsForValue = redisTemplate.opsForValue();
      opsForValue.set("user1",user);
      log.info("--get user form redis---" + opsForValue.get("user1"));



    }

}
