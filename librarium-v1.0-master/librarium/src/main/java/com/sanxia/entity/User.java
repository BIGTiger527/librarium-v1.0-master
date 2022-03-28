package com.sanxia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/7
 */
@Data
@Entity
@Table(name = "user")
//json序列化时将java bean中的一些属性忽略掉
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

public class User {

    @Id
    //生成一个唯一标识的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * 用于编码的盐。
     */
    private String salt;

    /**
     * Real name.
     */
    private String name;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Email address.
     */
    private String email;

    /**
     * User status.
     */
    private boolean enabled;

    /**
     * 用于存储当前用户拥有的角色的临时属性。@Transient:不能被序列化
     */
    @Transient
    private List<AdminRole> roles;

    // 默认构造函数
    public User() {}

    // 用于配合自定义查询的构造函数
    public User(int id,String username, String name, String phone, String email, boolean enabled) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.enabled = enabled;
    }
}

