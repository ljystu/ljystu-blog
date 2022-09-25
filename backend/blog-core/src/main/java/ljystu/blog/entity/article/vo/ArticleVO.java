package ljystu.blog.entity.article.vo;

import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author bobbi
 * @date 2019/01/08 19:04
 * @email 571002217@qq.com
 * @description
 */
@Data
public class ArticleVO extends Article {

    private List<Tag> tagList;

}
