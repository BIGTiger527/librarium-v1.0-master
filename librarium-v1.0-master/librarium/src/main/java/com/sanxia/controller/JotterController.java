package com.sanxia.controller;

import com.sanxia.entity.JotterArticle;
import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import com.sanxia.service.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;

    @PostMapping("api/admin/content/article")
    public Result saveArticle(@RequestBody JotterArticle article) {
        if(jotterArticleService.addOrUpdate(article)) {
            return ResultFactory.buildSuccessResult("保存成功！");
        }
        return ResultFactory.buildFailResult("参数错误，保存失败！");
    }

    @GetMapping("/api/article/{size}/{page}")
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(jotterArticleService.list(page - 1, size));
    }

    @GetMapping("/api/article/{id}")
    public Result getOneArticle(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(jotterArticleService.findById(id));
    }

    @DeleteMapping("/api/admin/content/article/{id}")
    public Result deleteArticle(@PathVariable("id") int id) {
        if(jotterArticleService.delete(id)) {
            return ResultFactory.buildSuccessResult("删除成功！");
        }
        return ResultFactory.buildFailResult("参数错误，删除失败！");
    }
}
