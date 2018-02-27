package com.simform.rushabhmodi.androidlearning.other;

/**
 * Created by rushabh.modi on 27/02/18.
 */

public class SqlitePojo {

    private int id;
    private String item;

    public SqlitePojo() {
    }

    public SqlitePojo(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }
}
