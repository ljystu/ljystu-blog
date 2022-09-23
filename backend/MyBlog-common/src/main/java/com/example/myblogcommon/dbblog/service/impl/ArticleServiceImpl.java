package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.Article;
import com.example.myblogcommon.dbblog.mapper.ArticleMapper;
import com.example.myblogcommon.dbblog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.myblogcommon.util.PageUtils;
import com.example.myblogcommon.util.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Article> page = baseMapper.selectPage(new Query<Article>(params).getPage(),
                new QueryWrapper<Article>().lambda());
        return new PageUtils(page);
    }

}
