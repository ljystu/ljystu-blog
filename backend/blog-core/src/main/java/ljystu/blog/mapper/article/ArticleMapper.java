package ljystu.blog.mapper.article;

import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.article.dto.ArticleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author bobbi
 * @since 2018-11-07
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {


    /**
     * 查询列表
     *
     * @param page
     * @param params
     * @return
     */
    List<ArticleDTO> listArticleVo(Page<ArticleDTO> page, @Param("params") Map<String, Object> params);

    /**
     * 根据条件查询分页
     *
     * @param page
     * @param params
     * @return
     */
    List<ArticleDTO> queryPageCondition(Page<ArticleDTO> page, @Param("params") Map<String, Object> params);

    /**
     * 更新阅读记录
     *
     * @param id
     */
    void updateReadNum(Integer id);

    /**
     * 获取简单的对象
     *
     * @param articleId
     * @return
     */
    ArticleDTO getSimpleArticleVo(Integer articleId);

    /**
     * 更新点赞记录
     *
     * @param parseInt
     */
    void updateLikeNum(int parseInt);

    /**
     * 判断类别下是否有文章
     *
     * @param categoryId
     * @return
     */
    int checkByCategory(Integer categoryId);

}
