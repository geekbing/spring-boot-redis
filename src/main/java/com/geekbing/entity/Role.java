package com.geekbing.entity;

import java.io.Serializable;

/**
 * Created by bing on 26/12/2016.
 */
public class Role implements Serializable {

    private Long id;

    private String name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
