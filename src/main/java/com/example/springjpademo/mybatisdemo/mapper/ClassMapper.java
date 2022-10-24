package com.example.springjpademo.mybatisdemo.mapper;
import com.example.springjpademo.mybatisdemo.dao.Class;

import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.LAZY;

@Mapper
public interface ClassMapper {
     @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "name",column = "name"),
             @Result(property = "teacherId",column = "teacher_id"),
             @Result(property = "teacher",column = "teacher_id", one = @One(select="com.example.springjpademo.mybatisdemo.mapper.TeacherMapper.findTeacherById",fetchType = LAZY)),
             @Result(property = "students",column = "id", many=@Many(select="com.example.springjpademo.mybatisdemo.mapper.StudentMapper.findStudentsByClassId",fetchType = LAZY))
     })
     //在写包名时注意路径正常,否则可能会报错误"Mapped Statements collection does not contain value"
     @Select("select id,name,teacher_id from t_class where id=#{id}")
     public Class getClassById(@Param("id") int id);

     @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "name",column = "name"),
             @Result(property = "teacherId",column = "teacher_id"),
             @Result(property = "teacher",column = "teacher_id", one = @One(select="com.example.springjpademo.mybatisdemo.mapper.TeacherMapper.findTeacherById",fetchType = LAZY)),
             @Result(property = "students",column = "id", many = @Many(select="com.example.springjpademo.mybatisdemo.mapper.StudentMapper.findStudentsByClassId",fetchType = LAZY))
     })
     @Select("select id,name,teacher_id from t_class where teacher_id=#{teacherId}")
     public List<Class> getClassByTeacherId(@Param("teacherId") int teacherId);
     @Insert("insert into t_class(name,teacher_id) values(#{name},#{teacherId})")
     @Options(useGeneratedKeys = true)
     public int save(Class myClass);
}
