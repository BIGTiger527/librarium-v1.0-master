package com.sanxia.service;

import com.sanxia.dao.JotterArticleDAO;
import com.sanxia.entity.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;

    public Page list(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
    }

    public JotterArticle findById(int id) {
        return jotterArticleDAO.findById(id);
    }

    public boolean addOrUpdate(JotterArticle article) {
        try {
            jotterArticleDAO.save(article);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            jotterArticleDAO.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
