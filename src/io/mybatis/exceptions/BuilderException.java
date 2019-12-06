package io.mybatis.exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/17
 **/
public class BuilderException extends RuntimeException {
    public BuilderException(String message) {
        super(message);
    }

    public BuilderException() {
        super();
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
