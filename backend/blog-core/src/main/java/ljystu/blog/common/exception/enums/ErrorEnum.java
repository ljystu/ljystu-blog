package ljystu.blog.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Error enums
 *
 * @Author: ljystu
 * @Date: 25/09/2022-16:01
 */

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    // 系统错误
    UNKNOWN(500, "Internal error"),
    PATH_NOT_FOUND(404, "Not found"),
    NO_AUTH(403, "Not authorized"),
    DUPLICATE_KEY(501, "Duplicate key in database"),
    TOKEN_GENERATOR_ERROR(502, "Token generator failed"),
    NO_UUID(503, "No uuid"),
    SQL_ILLEGAL(504, "Illegal Sql"),

    //用户权限错误
    INVALID_TOKEN(1001, "Illegal token"),

    //登录模块错误
    LOGIN_FAIL(10001, "Login failed"),
    CAPTCHA_WRONG(10002, "Wrong captcha"),
    USERNAME_OR_PASSWORD_WRONG(10003, "Username or password wrong");

    //七牛OSS错误
//    OSS_CONFIG_ERROR(10050, "七牛配置信息错误"),
//    OSS_UPLOAD_ERROR(10051, "OSSBookNote上传失败");

    private int code;
    private String msg;

}
