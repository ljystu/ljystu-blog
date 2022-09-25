package ljystu.blog.common.enums;

import lombok.Getter;


/**
 * MenuTypeEnum
 *
 * @Author: ljystu
 * @Date: 24/09/2022-18:20
 */


@Getter
public enum MenuTypeEnum {
    /**
     * Category
     */
    CATALOG(0),
    /**
     * Menu
     */
    MENU(1),
    /**
     * Button
     */
    BUTTON(2);

    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
