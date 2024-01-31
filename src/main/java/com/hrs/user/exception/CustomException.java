package com.hrs.user.exception;

/**
 * The type Custom exception.
 */
public class CustomException extends RuntimeException{
    /**
     * Instantiates a new Custom exception.
     */
    public CustomException() {
        super();
    }

    /**
     * Instantiates a new Custom exception.
     *
     * @param message the message
     */
    public CustomException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Custom exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Custom exception.
     *
     * @param cause the cause
     */
    public CustomException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Custom exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
