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
import com.example.myblogcommon.dbblog.entity.Book;
import com.example.myblogcommon.dbblog.service.BookService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 图书表 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/book")
public class BookController extends AbstractController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:book:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = bookService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:book:info")
    public Result info(@PathVariable("id") String id) {
        Book book = bookService.getById(id);

        return Result.ok().put("book", book);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:book:save")
    public Result save(@RequestBody Book book) {
        ValidatorUtils.validateEntity(book);
        bookService.save(book);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:book:update")
    public Result update(@RequestBody Book book) {
        ValidatorUtils.validateEntity(book);
        bookService.updateById(book);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:book:delete")
    public Result delete(@RequestBody String[] ids) {
        bookService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
