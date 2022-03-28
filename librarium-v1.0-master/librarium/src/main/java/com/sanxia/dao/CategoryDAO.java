package com.sanxia.dao;

import com.sanxia.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
