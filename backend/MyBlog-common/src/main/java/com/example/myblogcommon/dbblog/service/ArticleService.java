package com.example.myblogcommon.dbblog.service;

import com.example.myblogcommon.dbblog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myblogcommon.util.PageUtils;

import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
}
