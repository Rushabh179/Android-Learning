package com.simform.rushabhmodi.androidlearning.other;

/**
 * Created by rushabh.modi on 27/02/18.
 */

public class SqlitePojo {

    private int id;
    private int number;
    private String item;
    private String description;

    public SqlitePojo() {
    }

    public SqlitePojo(int number, String item, String description) {
        this.number = number;
        this.item = item;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }
}
