package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.Category;
import com.example.myblogcommon.dbblog.mapper.CategoryMapper;
import com.example.myblogcommon.dbblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.util.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Category> page = baseMapper.selectPage(new Query<Category>(params).getPage(),
                new QueryWrapper<Category>().lambda());
        return new PageUtils(page);
    }

}
