package ljystu.blog.common.mq.annotation;

import java.lang.annotation.*;


/**
 * RefreshEsMqSender Annotation
 *
 * @Author: ljystu
 * @Date: 25/09/2022-09:53
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshEsMqSender {
    String sender();

    String msg() default "send refresh msg to ElasticSearch";

}
