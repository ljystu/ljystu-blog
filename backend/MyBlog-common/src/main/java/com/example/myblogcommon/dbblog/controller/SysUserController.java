package com.example.myblogcommon.dbblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblogcommon.dbblog.entity.SysUser;
import com.example.myblogcommon.dbblog.service.SysUserService;
import com.example.myblogcommon.common.Result;
import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.validator.ValidatorUtils;
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
@RequestMapping("/admin/dbblog/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService userService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:user:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = userService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:user:info")
    public Result info(@PathVariable("id") String id) {
        SysUser user = userService.getById(id);

        return Result.ok().put("user", user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:user:save")
    public Result save(@RequestBody SysUser user) {
        ValidatorUtils.validateEntity(user);
        userService.save(user);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:user:update")
    public Result update(@RequestBody SysUser user) {
        ValidatorUtils.validateEntity(user);
        userService.updateById(user);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:user:delete")
    public Result delete(@RequestBody String[] ids) {
        userService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
