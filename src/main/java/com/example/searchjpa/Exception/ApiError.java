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

}