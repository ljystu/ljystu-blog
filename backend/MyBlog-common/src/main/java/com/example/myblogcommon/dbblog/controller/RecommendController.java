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
import com.example.myblogcommon.dbblog.entity.Recommend;
import com.example.myblogcommon.dbblog.service.RecommendService;

import org.springframework.web.bind.annotation.RestController;
import com.example.myblogcommon.base.AbstractController;

/**
 * <p>
 * 推荐 前端控制器
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@RestController
@Slf4j
@RequestMapping("/admin/dbblog/recommend")
public class RecommendController extends AbstractController {
    @Autowired
    private RecommendService recommendService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("dbblog:recommend:list")
    public Result list(@RequestParam Map
            <String, Object> params) {
        PageUtils page = recommendService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dbblog:recommend:info")
    public Result info(@PathVariable("id") String id) {
        Recommend recommend = recommendService.getById(id);

        return Result.ok().put("recommend", recommend);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("dbblog:recommend:save")
    public Result save(@RequestBody Recommend recommend) {
        ValidatorUtils.validateEntity(recommend);
        recommendService.save(recommend);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("dbblog:recommend:update")
    public Result update(@RequestBody Recommend recommend) {
        ValidatorUtils.validateEntity(recommend);
        recommendService.updateById(recommend);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("dbblog:recommend:delete")
    public Result delete(@RequestBody String[] ids) {
        recommendService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
