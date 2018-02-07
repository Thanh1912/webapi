package com.example.searchjpa.DTO;

import java.util.ArrayList;

public class RootObject
{
    public ArrayList<Item> items;

    public ArrayList<Item> getItems() { return this.items; }

    public void setItems(ArrayList<Item> items) { this.items = items; }
}
