package com.theguide.guidesoft.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class User {

    public String name;
    public String father;
    public String clas;
    public String mobile;
    public String old;
    public String grades;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String father, String clas, String mobile, String old, String grades) {
        this.name = name;
        this.father = father;
        this.clas = clas;
        this.mobile = mobile;
        this.old = old;
        this.grades = grades;
    }
}