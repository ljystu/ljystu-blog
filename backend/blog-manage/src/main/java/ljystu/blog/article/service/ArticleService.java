package ljystu.blog.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ljystu.blog.common.util.PageUtils;
import ljystu.blog.entity.article.Article;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public interface ArticleService extends IService<Article> {


    PageUtils queryPage(Map<String, Object> params);
}
