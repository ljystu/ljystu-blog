package ljystu.blog.entity.article.dto;

import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.article.vo.ArticleVO;
import ljystu.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author bobbi
 * @date 2019/01/09 16:51
 * @email 571002217@qq.com
 * @description 文章列表VO
 */
@Data
public class ArticleDTO extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    public void setFromArticleDTO(ArticleVO articleVO) {
        this.setId(articleVO.getId());
        this.setTitle(articleVO.getTitle());
        this.setDescription(articleVO.getDescription());
        this.setAuthor(articleVO.getAuthor());
        this.setContent(articleVO.getContent());
        this.setContentFormat(articleVO.getContentFormat());
        this.setReadNum(articleVO.getReadNum());
        this.setLikeNum(articleVO.getLikeNum());
        this.setCover(articleVO.getCover());
        this.setCoverType(articleVO.getCoverType());
        this.setCreateTime(articleVO.getCreateTime());
        this.setUpdateTime(articleVO.getUpdateTime());
        this.setRecommend(articleVO.getRecommend());
        this.setPublish(articleVO.getPublish());
        this.setTop(articleVO.getTop());
        this.setCategoryListStr(articleVO.getCategoryId());
        this.setTagList(articleVO.getTagList());


    }

}
