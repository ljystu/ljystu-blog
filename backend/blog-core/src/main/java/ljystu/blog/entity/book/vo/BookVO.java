package ljystu.blog.entity.book.vo;

import ljystu.blog.entity.book.Book;
import ljystu.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookDto
 *
 * @author bobbi
 * @date 2019/01/28 16:44
 * @email 571002217@qq.com
 * @description
 */
@Data
public class BookVO extends Book {

    List<Tag> tagList;
}
