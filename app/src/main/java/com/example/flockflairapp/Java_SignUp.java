package com.example.flockflairapp;

public class Java_SignUp {
    private String name;
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Java_SignUp(String name, String phone){
        this.name = name;
        this.phone = phone;

    }
}
