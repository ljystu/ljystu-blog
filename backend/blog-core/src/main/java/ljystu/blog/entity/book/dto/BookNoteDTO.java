package ljystu.blog.entity.book.dto;

import ljystu.blog.entity.book.Book;
import ljystu.blog.entity.book.BookNote;
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
public class BookNoteDTO extends BookNote {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属书本
     */
    private Book book;

}
