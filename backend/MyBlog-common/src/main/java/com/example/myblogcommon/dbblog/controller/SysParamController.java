package com.example.myblogcommon.dbblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblogcommon.dbblog.entity.SysParam;
import com.example.myblogcommon.dbblog.service.SysParamService;
import com.example.myblogcommon.common.Result;
import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/param")
public class SysParamController extends AbstractController {
    @Autowired
    private SysParamService paramService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:param:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = paramService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:param:info")
    public Result info(@PathVariable("id") String id) {
        SysParam param = paramService.getById(id);

        return Result.ok().put("param", param);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:param:save")
    public Result save(@RequestBody SysParam param) {
        ValidatorUtils.validateEntity(param);
        paramService.save(param);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:param:update")
    public Result update(@RequestBody SysParam param) {
        ValidatorUtils.validateEntity(param);
        paramService.updateById(param);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:param:delete")
    public Result delete(@RequestBody String[] ids) {
        paramService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
