package com.albatross.management.Albatross.Management.beans;

import java.util.Date;

public class DataItem {
    private int id;
    private String type;

    public DataItem(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
