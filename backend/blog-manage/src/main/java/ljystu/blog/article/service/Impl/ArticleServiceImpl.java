package ljystu.blog.article.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ljystu.blog.category.service.CategoryService;
import ljystu.blog.common.enums.ModuleEnum;
import ljystu.blog.common.util.PageUtils;
import ljystu.blog.common.util.Query;
import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.article.dto.ArticleDTO;
import ljystu.blog.entity.operation.Category;
import ljystu.blog.article.service.ArticleService;
import ljystu.blog.tag.service.TagService;
import ljystu.blog.mapper.article.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private TagService tagService;


    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleDTO> page = new Query<ArticleDTO>(params).getPage();
        List<ArticleDTO> articleDTOS = baseMapper.listArticleDTO(page, params);
        //search all article tags
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getType, ModuleEnum.ARTICLE.getValue()));

        if (articleDTOS != null) {
            for (ArticleDTO articleDTO : articleDTOS) {
                articleDTO.setCategoryListStr(categoryService.renderCategoryArr(articleDTO.getCategoryId(), categoryList));
                articleDTO.setTagList(tagService.listBylinkId(articleDTO.getId(), ModuleEnum.ARTICLE.getValue()));
            }
        }
        page.setRecords(articleDTOS);

        return new PageUtils(page);
    }
}
