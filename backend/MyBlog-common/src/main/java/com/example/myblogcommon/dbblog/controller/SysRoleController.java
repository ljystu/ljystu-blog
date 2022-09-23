package com.example.myblogcommon.dbblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblogcommon.dbblog.entity.SysRole;
import com.example.myblogcommon.dbblog.service.SysRoleService;
import com.example.myblogcommon.common.Result;
import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/role")
public class SysRoleController extends AbstractController {
    @Autowired
    private SysRoleService roleService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:role:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = roleService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:role:info")
    public Result info(@PathVariable("id") String id) {
        SysRole role = roleService.getById(id);

        return Result.ok().put("role", role);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:role:save")
    public Result save(@RequestBody SysRole role) {
        ValidatorUtils.validateEntity(role);
        roleService.save(role);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:role:update")
    public Result update(@RequestBody SysRole role) {
        ValidatorUtils.validateEntity(role);
        roleService.updateById(role);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:role:delete")
    public Result delete(@RequestBody String[] ids) {
        roleService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
