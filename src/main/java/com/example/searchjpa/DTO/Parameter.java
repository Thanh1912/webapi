package com.example.searchjpa.DTO;

public class Parameter
{
    public String eq;

    public String getEq() { return this.eq; }

    public void setEq(String eq) { this.eq = eq; }

    public String starts_with;

    public boolean is_null;

    public String getStarts_with() {
        return starts_with;
    }

    public void setStarts_with(String starts_with) {
        this.starts_with = starts_with;
    }

    public boolean isIs_null() {
        return is_null;
    }

    public void setIs_null(boolean is_null) {
        this.is_null = is_null;
    }
}
