package com.example.springjpademo.mybatisdemo.mapper;

import com.example.springjpademo.mybatisdemo.dao.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.LAZY;

@Mapper
public interface StudentMapper {
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "class_id",property = "classId"),
            @Result(column="class_id",property = "myClass",one = @One(select="com.example.springjpademo.mybatisdemo.mapper.ClassMapper.getClassById",fetchType=LAZY))
    })
    @Select("select id,name,class_id from t_student where id=#{id}")
    public Student findStudentById(@Param("id") int id);

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "class_id",property = "classId"),
            @Result(column="class_id",property = "myClass",one = @One(select="com.example.springjpademo.mybatisdemo.mapper.ClassMapper.getClassById",fetchType=LAZY))
    })
    @Select("select id,name,class_id from t_student where class_id=#{classId}")
    public List<Student> findStudentsByClassId(@Param("classId") int classId);

    @Insert("insert into t_student(name,class_id) values(#{name},#{classId})")
    @Options(useGeneratedKeys = true)
    public int save(Student student);


}
