package com.EXAM_MODULE2.model;

public abstract class Account {
    private int id;
    private String code;
    private String name;
    private String dateOpen;

    public Account() {
    }

    public Account(int id, String code, String name, String dateOpen) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOpen = dateOpen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,", id,code, name, dateOpen);
    }
}
