package com.example.springjpademo.jdbctemplate.repository;

import com.example.springjpademo.jdbctemplate.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getCountOfStudent(String name) {
        String sql = "select count(*) as number from student where name=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }

  //返回单列数据的时候，可以使用SingleColumnRowMapper
    public List<String> getStudentNameByAge(Integer age){
        String sql="select name from student where age>?";
        return jdbcTemplate.query(sql,new Object[]{age},new SingleColumnRowMapper<>(String.class));
    }
 //返回多列数据，且需要将多列数据映射到一个实体对象上则使用BeanPropertyRowMapper
    public List<Student> getSomeStudents(Integer age){
        String sql="select name,age,address from student where age>?";
        List<Student> studentList = jdbcTemplate.query(sql,new Object[]{age},new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }
    //自定义的RowMapper
    public void getStudentList() {
        String sql = "select name,age from student";
        List<Student> studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                return Student.builder().name(rs.getString(1))
                        .age(rs.getInt(2))
                        .build();
            }
        });
        studentList.forEach( student -> System.out.println(student));
    }
    public void addStudent(Student student){
        String sql="insert into student(name,age,address,postcode) value(?,?,?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getAddress(),student.getPostcode());
    }
    public void updateStudent(String name,int age){
        String sql="update student set age=? where name=?";
        jdbcTemplate.update(sql,age,name);
    }
//BATCHUPDATE()方法来执行批量插入操作。用这种方法，该语句只被编译一次，执行多次
    public void addManyStudent() {
        String sql = "insert into student(name,age,address,postcode) value(?,?,?,?)";
        jdbcTemplate.batchUpdate(sql,
               Arrays.asList(new Object[]{"one",20,"beijing","70010"},new Object[]{"two",30,"chengdu","70015"}));
    }
}
