package ljystu.blog.category.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ljystu.blog.common.util.PageUtils;
import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.operation.Category;

import java.util.HashMap;
import java.util.List;

public interface CategoryService extends IService<Category> {


    String renderCategoryArr(String categoryId, List<Category> categoryList);
}
