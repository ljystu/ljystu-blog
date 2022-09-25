package ljystu.blog.common.constants;


/**
 * RedisCacheNames
 *
 * @Author: ljystu
 * @Date: 24/09/2022-18:10
 */

public class RedisCacheNames {

    public final static String PROFIX = "BLOG:";

    /**
     * Article cache name
     */
    public final static String ARTICLE = PROFIX + "ARTICLE";
    /**
     * Book cache name
     */
    public final static String BOOK = PROFIX + "BOOK";

    /**
     * Book note cache name
     */
    public final static String BOOKNOTE = PROFIX + "BOOKNOTE";

    /**
     * Link cache name
     */
    public final static String LINK = PROFIX + "LINK";

    /**
     * Recommend list cache name
     */
    public final static String RECOMMEND = PROFIX + "RECOMMEND";

    /**
     * Tag cache name
     */
    public final static String TAG = PROFIX + "TAG";

    /**
     * Category cache name
     */
    public final static String CATEGORY = PROFIX + "CATEGORY";

    /**
     * Timeline cache name
     */
    public static final String TIMELINE = PROFIX + "TIMELINE";

}
