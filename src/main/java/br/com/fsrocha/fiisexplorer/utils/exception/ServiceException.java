package br.com.fsrocha.fiisexplorer.utils.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Filipe Rocha
 */
public class ServiceException extends RuntimeException {

    private final HttpStatus category;
    private final String errorCode;

    public ServiceException(HttpStatus category, String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.category = category;
        this.errorCode = errorCode;
    }

    public ServiceException(HttpStatus category, String message, String errorCode) {
        this(category, message, errorCode, null);
    }

    public ServiceException(HttpStatus errorCategory, String message) {
        this(errorCategory, message, null, null);
    }

    public ServiceException(HttpStatus category, Throwable cause) {
        this(category, cause != null ? cause.getMessage() : null, null, null);
    }

    public ServiceException(HttpStatus category) {
        this(category, null, null, null);
    }

    public HttpStatus getErrorCategory() {
        return category;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
