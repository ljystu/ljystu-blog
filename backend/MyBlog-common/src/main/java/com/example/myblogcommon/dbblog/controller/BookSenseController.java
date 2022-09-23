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
import com.example.myblogcommon.dbblog.entity.BookSense;
import com.example.myblogcommon.dbblog.service.BookSenseService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 读后感 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/sense")
public class BookSenseController extends AbstractController {
    @Autowired
    private BookSenseService senseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:sense:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = senseService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:sense:info")
    public Result info(@PathVariable("id") String id) {
        BookSense sense = senseService.getById(id);

        return Result.ok().put("sense", sense);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:sense:save")
    public Result save(@RequestBody BookSense sense) {
        ValidatorUtils.validateEntity(sense);
        senseService.save(sense);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:sense:update")
    public Result update(@RequestBody BookSense sense) {
        ValidatorUtils.validateEntity(sense);
        senseService.updateById(sense);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:sense:delete")
    public Result delete(@RequestBody String[] ids) {
        senseService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
