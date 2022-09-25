package ljystu.blog.common.enums;

import lombok.Getter;


/**
 * TypeEnum
 *
 * @Author: ljystu
 * @Date: 24/09/2022-18:21
 */


@Getter
public enum ModuleEnum {
    /**
     * Article
     */
    ARTICLE(0),
    /**
     * Book
     */
    BOOK(1),
    /**
     * Book note
     */
    BOOK_NOTE(2);

    private int value;

    ModuleEnum(int value) {
        this.value = value;
    }
}
