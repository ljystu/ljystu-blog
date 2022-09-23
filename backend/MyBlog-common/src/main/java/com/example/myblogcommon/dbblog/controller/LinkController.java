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
import com.example.myblogcommon.dbblog.entity.Link;
import com.example.myblogcommon.dbblog.service.LinkService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 友链 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/link")
public class LinkController extends AbstractController {
    @Autowired
    private LinkService linkService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:link:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = linkService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:link:info")
    public Result info(@PathVariable("id") String id) {
        Link link = linkService.getById(id);

        return Result.ok().put("link", link);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:link:save")
    public Result save(@RequestBody Link link) {
        ValidatorUtils.validateEntity(link);
        linkService.save(link);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:link:update")
    public Result update(@RequestBody Link link) {
        ValidatorUtils.validateEntity(link);
        linkService.updateById(link);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:link:delete")
    public Result delete(@RequestBody String[] ids) {
        linkService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
