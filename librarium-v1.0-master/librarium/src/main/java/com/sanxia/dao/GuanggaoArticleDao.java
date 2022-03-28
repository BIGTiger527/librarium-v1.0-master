package com.sanxia.dao;

import com.sanxia.entity.GuanggaoArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2022/3/22
 */
public interface GuanggaoArticleDao extends JpaRepository<GuanggaoArticle,Integer> {
    GuanggaoArticle findById(int id);
}
