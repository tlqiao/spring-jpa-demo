package com.example.springjpademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class JedisDemoApplication implements ApplicationRunner {
    public static void main(String[] args){
        SpringApplication.run(JedisDemoApplication.class,args);
    }

    @Bean
    @ConfigurationProperties("redis")
    //获取配置信息的Bean配置，读取的properties文件的配置前缀
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod="close")
    public JedisPool jedisPool() {return new JedisPool(jedisPoolConfig(), "localhost",6379);}
    @Override
    public void run(ApplicationArguments  args) {
        log.info(jedisPoolConfig().toString());
        try (Jedis jedis = jedisPool().getResource()){
          jedis.set("myKey","myValue");
          jedis.hset("user1","name","zhangsan");
          jedis.hset("user1","age","100");
          jedis.hset("user2","name","lisi");
          jedis.hset("user2","age","200");
         Map<String,String> userInfo= jedis.hgetAll("user1");
         log.info(userInfo.get("name"));
         log.info(userInfo.get("age"));
         String userName=jedis.hget("user2","name");
         log.info(userName);
         String value=jedis.get("myKey");
         log.info(value);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
