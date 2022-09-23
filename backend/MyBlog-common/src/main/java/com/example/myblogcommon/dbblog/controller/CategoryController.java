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
import com.example.myblogcommon.dbblog.entity.Category;
import com.example.myblogcommon.dbblog.service.CategoryService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/category")
public class CategoryController extends AbstractController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:category:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:category:info")
    public Result info(@PathVariable("id") String id) {
        Category category = categoryService.getById(id);

        return Result.ok().put("category", category);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:category:save")
    public Result save(@RequestBody Category category) {
        ValidatorUtils.validateEntity(category);
        categoryService.save(category);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:category:update")
    public Result update(@RequestBody Category category) {
        ValidatorUtils.validateEntity(category);
        categoryService.updateById(category);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:category:delete")
    public Result delete(@RequestBody String[] ids) {
        categoryService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
