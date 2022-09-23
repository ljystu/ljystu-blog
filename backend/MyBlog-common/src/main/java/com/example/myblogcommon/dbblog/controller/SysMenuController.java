package com.example.myblogcommon.dbblog.controller;

import com.example.myblogcommon.common.validator.ValidatorUtils;
import com.example.myblogcommon.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblogcommon.dbblog.entity.SysMenu;
import com.example.myblogcommon.dbblog.service.SysMenuService;

import com.example.myblogcommon.common.util.PageUtils;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/menu")
public class SysMenuController extends AbstractController {
    @Autowired
    private SysMenuService menuService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:menu:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = menuService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:menu:info")
    public Result info(@PathVariable("id") String id) {
        SysMenu menu = menuService.getById(id);

        return Result.ok().put("menu", menu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:menu:save")
    public Result save(@RequestBody SysMenu menu) {
        ValidatorUtils.validateEntity(menu);
        menuService.save(menu);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:menu:update")
    public Result update(@RequestBody SysMenu menu) {
        ValidatorUtils.validateEntity(menu);
        menuService.updateById(menu);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:menu:delete")
    public Result delete(@RequestBody String[] ids) {
        menuService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
