package com.example.searchjpa.Exception.model;

public class Error
{
    public Error(String resource, String field, String code, String message, String details) {
        this.resource = resource;
        this.field = field;
        this.code = code;
        this.message = message;
        this.details = details;
    }

    private String resource;

    public String getResource() { return this.resource; }

    public void setResource(String resource) { this.resource = resource; }

    private String field;

    public String getField() { return this.field; }

    public void setField(String field) { this.field = field; }

    private String code;

    public String getCode() { return this.code; }

    public void setCode(String code) { this.code = code; }

    private String message;

    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }

    private String details;

    public String getDetails() { return this.details; }

    public void setDetails(String details) { this.details = details; }
}
