package com.example.myblogcommon.dbblog.controller;

import com.example.myblogcommon.entity.Result;
import com.example.myblogcommon.util.PageUtils;
import com.example.myblogcommon.util.ValidatorUtils;
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
 * 文章 前端控制器
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
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:article:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:article:info")
    public Result info(@PathVariable("id") String id) {
        Article article = articleService.getById(id);

        return Result.ok().put("article", article);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:article:save")
    public Result save(@RequestBody Article article) {
        ValidatorUtils.validateEntity(article);
        articleService.save(article);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:article:update")
    public Result update(@RequestBody Article article) {
        ValidatorUtils.validateEntity(article);
        articleService.updateById(article);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:article:delete")
    public Result delete(@RequestBody String[] ids) {
        articleService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
