package com.sanxia.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * 角色和菜单之间的关系。
 * User: 冯寒斌
 * Date: 2021/11/19
 */
@Data
@Entity
@Table(name = "admin_role_menu")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class AdminRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Menu id.
     */
    private int mid;
}
