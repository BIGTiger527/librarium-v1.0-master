package com.sanxia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
@Data
@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Menu access path.
     */
    private String path;

    /**
     * Menu name.
     */
    private String name;

    /**
     * Menu name in Chinese.
     */
    private String nameZh;

    /**
     * Menu icon class(use element-ui icons).
     */
    private String iconCls;

    /**
     * 对应于菜单的前端组件名称。
     */
    private String component;

    /**
     * Parent menu.
     */
    private int parentId;

    /**
     * 用于存储子菜单的瞬态属性。
     */
    @Transient
    private List<AdminMenu> children;
}
