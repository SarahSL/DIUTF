package com.example.sarah.plasticbeach.models;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created by Sarah on 13/01/2018.
 */

public class Beach {
    private String username;
    private String description;
    private Date date;
    private Drawable photo;

    public Beach(String username) {
        this.username = username;
        this.date = new Date();
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
