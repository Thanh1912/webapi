package com.example.searchjpa.Exception;

import javax.persistence.EntityNotFoundException;
import com.example.searchjpa.Exception.model.*;
import com.example.searchjpa.Exception.model.Error;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		String error = "Malformed JSON request";
//		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
//	}

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError,HttpStatus httpStatus) {
        return new ResponseEntity<>(apiError,httpStatus);
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    protected ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException ex) {
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//        apiError.setMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    protected ResponseEntity<ApiError> handleAuthenticationException(ResourceNotFoundException ex) {
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//        apiError.setMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ApiError> handleAuthenticationException(BadRequestException ex) {
        return buildResponseEntity(ex.getApiError(),HttpStatus.BAD_REQUEST);
    }

}


