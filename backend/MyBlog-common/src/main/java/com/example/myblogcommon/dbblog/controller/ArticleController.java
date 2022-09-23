package com.example.myblogcommon.dbblog.controller;

import com.example.myblogcommon.common.Result;
import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.validator.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblogcommon.dbblog.entity.Article;
import com.example.myblogcommon.dbblog.service.ArticleService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * Articles
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/article")
public class ArticleController extends AbstractController {
    @Autowired
    private ArticleService articleService;

    /**
     * list
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:article:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * info
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:article:info")
    public Result info(@PathVariable("id") String id) {
        Article article = articleService.getById(id);

        return Result.ok().put("article", article);
    }

    /**
     * save
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:article:save")
    public Result save(@RequestBody Article article) {
        ValidatorUtils.validateEntity(article);
        articleService.save(article);

        return Result.ok();
    }

    /**
     * update
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:article:update")
    public Result update(@RequestBody Article article) {
        ValidatorUtils.validateEntity(article);
        articleService.updateById(article);
        return Result.ok();
    }

    /**
     * delete
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:article:delete")
    public Result delete(@RequestBody String[] ids) {
        articleService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
