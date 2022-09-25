package ljystu.blog.entity.book.vo;

import ljystu.blog.entity.book.BookNote;
import ljystu.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * BookNote
 *
 * @author bobbi
 * @date 2019/01/08 19:04
 * @email 571002217@qq.com
 * @description
 */
@Data
public class BookNoteVO extends BookNote {

    private List<Tag> tagList;

}
