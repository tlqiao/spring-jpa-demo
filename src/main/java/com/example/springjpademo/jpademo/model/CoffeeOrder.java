package com.example.springjpademo.jpademo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="T_ORDER")
@Data
@ToString(callSuper = true)
@Builder
//使用了@Data注解, 调用toString时只会打印子类本身的属性值, 如果想要打印父类的属性，
//子类加上@Data和@ToString(callSuper = true)两个注解, 父类也使用注解@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity implements Serializable {
    private String name;
    @ManyToMany
    @JoinTable(name="T_ORDER_COFFEE")
    private List<Coffee> items;
    @Enumerated
    //表示映射到枚举字段
    @Column(nullable = false)
    //@Column常用参数包括unique,nullable,updatable,insertable
    private OrderState state;
}
