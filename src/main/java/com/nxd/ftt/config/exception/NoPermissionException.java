package com.nxd.ftt.config.exception;

/**
 * NoPermissionException
 *
 * @author luhangqi
 * @date 2018/11/2
 */
public class NoPermissionException extends RuntimeException {

    public NoPermissionException() {
        super();
    }

    public NoPermissionException(String message) {
        super(message);
    }
}
