package com.sanxia.service;

import com.sanxia.dao.GuanggaoArticleDao;
import com.sanxia.entity.GuanggaoArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2022/3/22
 */
@Service
public class GuanggaoArticleService {
    @Autowired
    GuanggaoArticleDao guanggaoArticleDao;

    public Page list(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return guanggaoArticleDao.findAll(PageRequest.of(page, size, sort));
    }

    public GuanggaoArticle findById(int id) {
        return guanggaoArticleDao.findById(id);
    }

    public boolean addOrUpdate(GuanggaoArticle article) {
        try {
            guanggaoArticleDao.save(article);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            guanggaoArticleDao.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
