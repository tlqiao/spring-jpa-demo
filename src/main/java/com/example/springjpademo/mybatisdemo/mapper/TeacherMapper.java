package com.example.springjpademo.mybatisdemo.mapper;

import com.example.springjpademo.mybatisdemo.dao.Teacher;
import org.apache.ibatis.annotations.*;

import static org.apache.ibatis.mapping.FetchType.LAZY;

@Mapper
public interface TeacherMapper {
    @Results({@Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "classList", many = @Many(select = "com.example.springjpademo.mybatisdemo.mapper.ClassMapper.getClassByTeacherId", fetchType = LAZY))})
    @Select("select id,name from t_teacher  where id=#{id}")
    public Teacher findTeacherById(@Param("id") int id);

    @Results({@Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "classList", many = @Many(select = "com.example.springjpademo.mybatisdemo.mapper.ClassMapper.getClassByTeacherId", fetchType = LAZY))}
    )
    @Select("select id,name from t_teacher")
    public Teacher findAll();

    @Insert("insert into t_teacher(name) values(#{name})")
    @Options(useGeneratedKeys = true)
    public int save(Teacher teacher);
}
