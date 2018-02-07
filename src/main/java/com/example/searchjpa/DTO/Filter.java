package com.example.searchjpa.DTO;

import java.util.ArrayList;

public class Filter
{
    public ArrayList<And> and;

    public ArrayList<And> getAnd() { return this.and; }

    public ArrayList<Or> or;

    public ArrayList<Or> getOr() { return this.or; }

    public void setOr(ArrayList<Or> or) { this.or = or; }

    public void setAnd(ArrayList<And> and) { this.and = and; }

    private Attribute attribute;

    public Attribute getAttribute() { return this.attribute; }

    public void setAttribute(Attribute attribute) { this.attribute = attribute; }

    private Parameter parameter;

    public Parameter getParameter() { return this.parameter; }

    public void setParameter(Parameter parameter) { this.parameter = parameter; }
}


