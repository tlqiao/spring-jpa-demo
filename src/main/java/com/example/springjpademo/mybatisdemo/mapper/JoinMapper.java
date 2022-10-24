package com.example.springjpademo.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.type.JdbcType.INTEGER;
import static org.apache.ibatis.type.JdbcType.VARCHAR;

@Mapper
public interface JoinMapper {

    @Results({
            @Result(column = "teacherId", property = "teacherId", jdbcType = INTEGER),
            @Result(column = "teacherName", property = "teacherName", jdbcType = VARCHAR),
            @Result(column = "classId", property = "classId", jdbcType = INTEGER),
            @Result(column = "className", property = "className", jdbcType = VARCHAR),
            @Result(column = "studentId", property = "studentId", jdbcType = INTEGER),
            @Result(column = "studentName", property = "studentName", jdbcType = VARCHAR)
    })
    @Select("select t.id teacherId, t.name teacherName, c.id classId, c.name className, s.id studentId, s.name studentName " +
            "from t_teacher t " +
            "inner join t_class c on t.id = c.teacher_id " +
            "inner join t_student s on c.id = s.class_id")
    List<Map<String, Object>> joinAll();
}
