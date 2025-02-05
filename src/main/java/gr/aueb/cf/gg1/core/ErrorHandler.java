package gr.aueb.cf.gg1.core;

import gr.aueb.cf.gg1.core.exceptions.*;
import gr.aueb.cf.gg1.dto.ResponseMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(ValidationException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AppObjectNotFoundException.class})
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectNotFoundException ex) {
        return new ResponseEntity<>(new ResponseMessageDTO(ex.getCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AppObjectAlreadyExists.class})
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectAlreadyExists ex) {
        return new ResponseEntity<>(new ResponseMessageDTO(ex.getCode(), ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({AppObjectInvalidArgumentException.class})
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectInvalidArgumentException ex) {
        return new ResponseEntity<>(new ResponseMessageDTO(ex.getCode(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AppServerException.class})
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppServerException ex) {
        return new ResponseEntity<>(new ResponseMessageDTO(ex.getCode(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
