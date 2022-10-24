package com.example.springjpademo.jpademo.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
//使用了@Data注解, 调用toString时只会打印子类本身的属性值, 如果想要打印父类的属性，
//子类加上@Data和@ToString(callSuper = true)两个注解, 父类也使用注解@Data
@Entity
@Table(name="T_MENU")
public class Coffee extends BaseEntity implements Serializable {
private String name;
@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
        parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
private Money price;
}
