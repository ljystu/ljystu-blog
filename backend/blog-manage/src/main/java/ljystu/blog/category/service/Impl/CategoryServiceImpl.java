package ljystu.blog.category.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiniu.util.StringUtils;
import ljystu.blog.entity.operation.Category;
import ljystu.blog.category.service.CategoryService;
import ljystu.blog.mapper.operation.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    /**
     * @param categoryIds
     * @param categoryList
     * @return
     */
    @Override
    public String renderCategoryArr(String categoryIds, List<Category> categoryList) {
        if (StringUtils.isNullOrEmpty(categoryIds)) {
            return "";
        }
        List<String> categoryStrList = new ArrayList<>();
        String[] categories = categoryIds.split(",");
        for (String str : categories) {
            int categoryId = Integer.parseInt(str);
            String categoryFound = categoryList.stream()
                    .filter(category -> category.getId().equals(categoryId))
                    .map(Category::getName)
                    .findAny().orElse("category not found");
            categoryStrList.add(categoryFound);
        }
        return StringUtils.join(categoryList, ",");
    }
}
