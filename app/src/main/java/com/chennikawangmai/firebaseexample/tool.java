package com.chennikawangmai.firebaseexample;

public class tool {
    public Integer nooftools;
    public String ID;
    public String name;

    public tool(Integer nooftools, String name, String ID) {
        this.nooftools = nooftools;
        this.name = name;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Integer getNooftools() {
        return nooftools;
    }
}
