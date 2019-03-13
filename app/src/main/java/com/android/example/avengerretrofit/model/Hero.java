package com.android.example.avengerretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Hero {

    private String name;
    @SerializedName("realname")
    private String realName;

    public Hero(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}