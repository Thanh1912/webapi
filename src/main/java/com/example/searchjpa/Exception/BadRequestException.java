package com.example.searchjpa.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1L;
    ApiError apiError;
    public BadRequestException(ApiError apiError) {
       this.apiError=apiError;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}