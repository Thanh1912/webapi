package com.example.searchjpa.Exception.model;

public class Errors
{
    public Errors(Error error, Meta meta) {
        this.error = error;
        this.meta = meta;
    }

    private Error error;

    public Error getError() { return this.error; }

    public void setError(Error error) { this.error = error; }

    private Meta meta;

    public Meta getMeta() { return this.meta; }

    public void setMeta(Meta meta) { this.meta = meta; }
}
