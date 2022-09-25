package ljystu.blog.common.enums;

import lombok.Getter;


/**
 * CategoryRankEnum
 *
 * @Author: ljystu
 * @Date: 24/09/2022-18:18
 */

@Getter
public enum CategoryRankEnum {

    /**
     * Root
     */
    ROOT(-1),
    /**
     * First
     */
    FIRST(0),
    /**
     * Second
     */
    SECOND(1),
    /**
     * Third
     */
    THIRD(2);

    private int value;

    CategoryRankEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
