package com.example.searchjpa.Exception.model;

import java.util.ArrayList;

public class ExceptionApi {
    private ArrayList<Errors> errors;

    public ArrayList<Errors> getErrors() { return this.errors; }

    public void setErrors(ArrayList<Errors> errors) { this.errors = errors; }

    private Meta meta;

    public Meta getMeta() { return this.meta; }

    public void setMeta(Meta meta) { this.meta = meta; }
}



