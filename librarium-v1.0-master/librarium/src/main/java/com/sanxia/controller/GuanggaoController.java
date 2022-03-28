package com.sanxia.controller;

import com.sanxia.entity.GuanggaoArticle;
import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import com.sanxia.service.GuanggaoArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2022/3/22
 */
@RestController
public class GuanggaoController {
    @Autowired
    GuanggaoArticleService guanggaoArticleService;


    @PostMapping("api/admin/content/guanggaoarticle")
    public Result saveArticle(@RequestBody GuanggaoArticle article) {
        if(guanggaoArticleService.addOrUpdate(article)) {
            return ResultFactory.buildSuccessResult("保存成功！");
        }
        return ResultFactory.buildFailResult("参数错误，保存失败！");
    }

    @GetMapping("/api/guanggaoarticle/{size}/{page}")
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(guanggaoArticleService.list(page - 1, size));
    }

    @GetMapping("/api/guanggaoarticle/{id}")
    public Result getOneArticle(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(guanggaoArticleService.findById(id));
    }

    @DeleteMapping("/api/admin/content/guanggaoarticle/{id}")
    public Result deleteArticle(@PathVariable("id") int id) {
        if(guanggaoArticleService.delete(id)) {
            return ResultFactory.buildSuccessResult("删除成功！");
        }
        return ResultFactory.buildFailResult("参数错误，删除失败！");
    }
}
