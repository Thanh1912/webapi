package com.example.searchjpa.Exception;

import com.example.searchjpa.Exception.model.Errors;
import com.example.searchjpa.Exception.model.Meta;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {


    private ArrayList<Errors> errors;

    public ArrayList<Errors> getErrors() { return this.errors; }

    public void setErrors(ArrayList<Errors> errors) { this.errors = errors; }

    private Meta meta;

    public Meta getMeta() { return this.meta; }

    public void setMeta(Meta meta) { this.meta = meta; }

    public ApiError(ArrayList<Errors> errors, Meta meta) {
        this.errors = errors;
        this.meta = meta;
    }


    //    private HttpStatus status;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
//    private LocalDateTime timestamp;
//
//    private int statusCode;
//    private String message;
//    private String debugMessage;
//
//
//    private ApiError() {
//        timestamp = LocalDateTime.now();
//    }
//
//    ApiError(HttpStatus status) {
//        this();
//        this.status = status;
//        this.statusCode = status.value();
//    }
//
//    ApiError(HttpStatus status, Throwable ex) {
//        this();
//        this.status = status;
//        this.statusCode = status.value();
//        this.message = "Unexpected error";
//        this.debugMessage = ex.getLocalizedMessage();
//    }
//
//    ApiError(HttpStatus status, String message, Throwable ex) {
//        this();
//        this.status = status;
//        this.statusCode = status.value();
//        this.message = message;
//        this.debugMessage = ex.getLocalizedMessage();
//    }
//
//    public HttpStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(HttpStatus status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(LocalDateTime timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getDebugMessage() {
//        return debugMessage;
//    }
//
//    public void setDebugMessage(String debugMessage) {
//        this.debugMessage = debugMessage;
//    }
//
//
//
//    public int getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(int statusCode) {
//        this.statusCode = statusCode;
//    }

}