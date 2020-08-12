package br.com.fsrocha.fiisexplorer.utils.exception;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fsrocha.fiisexplorer.utils.valid.FieldError;

/**
 * @author Filipe Rocha
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    public final ResponseEntity<HashMap<String, String>> handleAllExceptions(ServiceException ex) {
        HashMap<String, String> errorResponse = new HashMap<>();
        errorResponse.put("reason", ex.getErrorCategory().name());
        if (ex.getErrorCode() != null) {
            errorResponse.put("errorCode", ex.getErrorCode());
        }
        errorResponse.put("message", ex.getMessage() != null ? ex.getMessage() : ex.getErrorCategory().getReasonPhrase());
        return new ResponseEntity<>(errorResponse, ex.getErrorCategory());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError fieldErrorResponse = new FieldError(status.name());
        HashMap<String, String> fieldError = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String message = fieldError.get(fieldName) == null ? error.getDefaultMessage() : fieldError.get(fieldName) + "; " + error.getDefaultMessage();
            fieldError.put(fieldName, message);
        });

        fieldErrorResponse.setErrors(fieldError);
        return new ResponseEntity<>(fieldErrorResponse, status);
    }

}
