package com.example.myblogcommon.dbblog.mapper;

import com.example.myblogcommon.dbblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
