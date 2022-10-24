package com.example.springjpademo.mybatisdemo.mapper;

import com.example.springjpademo.mybatisdemo.dao.Coffee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CoffeeMapper {
    //#{}方式能够很大程度防止sql注入(安全)，${}方式无法防止Sql注入,建议都采用#{}方式
    @Insert("insert into t_coffee(name,price,create_time,update_time) values(#{name},#{price},now(),now())")
    @Options(useGeneratedKeys = true)
    public int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    //@Result修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
            // map-underscore-to-camel-case = true 可以实现一样的效果
            // @Result(column = "update_time", property = "updateTime"),
    })
    public Coffee findCoffeeById(@Param("id") Long id);
}
