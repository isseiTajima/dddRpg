package com.rpg.dddrpg.domain.exception;

/**
 * 業務(検査)例外
 */
public class BusinessException extends RuntimeException {

    public BusinessException(Throwable t) {
        super(t);
    }

    public BusinessException(String message) {
        super(message);
    }
}
