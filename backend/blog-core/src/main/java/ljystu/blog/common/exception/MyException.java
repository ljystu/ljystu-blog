package ljystu.blog.common.exception;

import ljystu.blog.common.exception.enums.ErrorEnum;
import lombok.Data;


/**
 * MyException
 *
 * @Author: ljystu
 * @Date: 25/09/2022-16:05
 */

@Data
public class MyException extends RuntimeException {
    private String msg;
    private int code = 500;

    public MyException() {
        super(ErrorEnum.UNKNOWN.getMsg());
        this.msg = ErrorEnum.UNKNOWN.getMsg();
    }


    public MyException(ErrorEnum eEnum, Throwable e) {
        super(eEnum.getMsg(), e);
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(ErrorEnum eEnum) {
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(String exception) {
        this.msg = exception;
    }

}
