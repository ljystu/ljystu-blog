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
import com.example.myblogcommon.dbblog.entity.LogLike;
import com.example.myblogcommon.dbblog.service.LogLikeService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 点赞日志 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/like")
public class LogLikeController extends AbstractController {
    @Autowired
    private LogLikeService likeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:like:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = likeService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:like:info")
    public Result info(@PathVariable("id") String id) {
        LogLike like = likeService.getById(id);

        return Result.ok().put("like", like);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:like:save")
    public Result save(@RequestBody LogLike like) {
        ValidatorUtils.validateEntity(like);
        likeService.save(like);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:like:update")
    public Result update(@RequestBody LogLike like) {
        ValidatorUtils.validateEntity(like);
        likeService.updateById(like);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:like:delete")
    public Result delete(@RequestBody String[] ids) {
        likeService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
