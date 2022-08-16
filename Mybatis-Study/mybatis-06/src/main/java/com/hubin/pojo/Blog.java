package com.hubin.pojo;

import java.util.Date;
import lombok.*;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date create_time;
    private int views;

    public Blog(String id, String title, String author, Date create_time, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.create_time = create_time;
        this.views = views;
    }
}
