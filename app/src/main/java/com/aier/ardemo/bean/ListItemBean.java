package com.aier.ardemo.bean;

public class ListItemBean {
    String mARKey;
    int mARType;
    String mName;
    String mDescription;
    String mARPath;

    public ListItemBean(int arType, String arKey, String arPath) {
        this.mARType = arType;
        this.mARKey = arKey;
        this.mARPath = arPath;
    }
    public ListItemBean(String mName,int arType, String arKey, String arPath) {
        this.mName = mName;
        this.mARType = arType;
        this.mARKey = arKey;
        this.mARPath = arPath;
    }
    public String getARKey() {
        return mARKey;
    }

    public int getARType() {
        return mARType;
    }

    public String getARPath() {
        return mARPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
