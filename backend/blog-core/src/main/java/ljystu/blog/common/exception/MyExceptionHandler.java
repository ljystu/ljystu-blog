package ljystu.blog.common.exception;

import ljystu.blog.common.Result;
import ljystu.blog.common.exception.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * ExceptionHandler
 *
 * @Author: ljystu
 * @Date: 25/09/2022-16:06
 */

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    /**
     * Handle exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e) {
        Result result = new Result();
        result.put("code", e.getCode());
        result.put("msg", e.getMsg());
        return result;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.exception(ErrorEnum.PATH_NOT_FOUND);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return Result.exception(ErrorEnum.DUPLICATE_KEY);
    }

    @ExceptionHandler(AuthorizationException.class)
    public Result handleAuthorizationException(AuthorizationException e) {
        log.error(e.getMessage(), e);
        return Result.exception(ErrorEnum.NO_AUTH);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.exception();
    }
}
