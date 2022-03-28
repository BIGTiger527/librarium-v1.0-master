package com.sanxia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户和角色之间的关系。
 * User: 冯寒斌
 * Date: 2021/11/25
 */
@Data
@Entity
@Table(name = "admin_user_role")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User id.
     */
    private int uid;

    /**
     * Role id.
     */
    private int rid;
}
