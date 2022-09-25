package ljystu.blog.common.base;

import ljystu.blog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;


/**
 * @Author: ljystu
 * @Date: 24/09/2022-18:27
 */

public class AbstractController {

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getUserId();
    }
}
