package com.example.searchjpa.Exception.model;

public class Meta
{


    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private Links links;

    public Links getLinks() { return this.links; }

    public void setLinks(Links links) { this.links = links; }
    private String type;

    private String http_status;

    public String getHttpStatus() { return this.http_status; }

    public void setHttpStatus(String http_status) { this.http_status = http_status; }

    private String logref;

    public String getLogref() { return this.logref; }

    public void setLogref(String logref) { this.logref = logref; }



}
