package com.sanxia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Category entity.
 * User: 冯寒斌
 * Date: 2021/11/23
 */
@Data
@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = { "handler","hibernateLazyInitializer" })

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Category name in Chinese.
     */
    private String name;
}
