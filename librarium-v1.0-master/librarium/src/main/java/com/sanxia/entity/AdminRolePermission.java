package com.sanxia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * 角色和权限之间的关系。
 * User: 冯寒斌
 * Date: 2021/11/23
 */
@Data
@Entity
@Table(name = "admin_role_permission")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class AdminRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Permission id.
     */
    private int pid;
}
