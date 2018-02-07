package com.example.searchjpa.DTO;

import java.util.ArrayList;
import java.util.List;

public class And
{
    public Filter filter;

    public Filter getFilter() { return this.filter; }

    public void setFilter(Filter filter) { this.filter = filter; }

    private ArrayList<And> and;

    public ArrayList<And> getAnd() { return this.and; }

    public void setAnd(ArrayList<And> and) { this.and = and; }

    private ArrayList<Or> or;

    public ArrayList<Or> getOr() { return this.or; }

    public void setOr(ArrayList<Or> Or) { this.or = Or; }
}

