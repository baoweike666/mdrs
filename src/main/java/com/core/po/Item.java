package com.core.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer item_user_id;
    private Integer item_movie_id;

    public Integer getItem_user_id() {
        return item_user_id;
    }

    public void setItem_user_id(Integer item_user_id) {
        this.item_user_id = item_user_id;
    }

    public Integer getItem_movie_id() {
        return item_movie_id;
    }

    public void setItem_movie_id(Integer item_movie_id) {
        this.item_movie_id = item_movie_id;
    }
}
