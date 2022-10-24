package com.example.springjpademo.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
// @MappedSuperclass类将不是一个完整的实体类，他将不会映射到数据库表，但他的属性将映射到其他子类的数据库字段上。添加该注解后，不能再添加@Entity@Table注解
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
}
