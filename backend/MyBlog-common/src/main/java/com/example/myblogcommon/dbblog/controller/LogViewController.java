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
import com.example.myblogcommon.dbblog.entity.LogView;
import com.example.myblogcommon.dbblog.service.LogViewService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 阅读日志 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/view")
public class LogViewController extends AbstractController {
    @Autowired
    private LogViewService viewService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:view:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = viewService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:view:info")
    public Result info(@PathVariable("id") String id) {
        LogView view = viewService.getById(id);

        return Result.ok().put("view", view);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:view:save")
    public Result save(@RequestBody LogView view) {
        ValidatorUtils.validateEntity(view);
        viewService.save(view);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:view:update")
    public Result update(@RequestBody LogView view) {
        ValidatorUtils.validateEntity(view);
        viewService.updateById(view);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:view:delete")
    public Result delete(@RequestBody String[] ids) {
        viewService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
