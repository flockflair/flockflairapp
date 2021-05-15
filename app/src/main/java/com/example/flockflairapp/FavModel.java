package com.example.flockflairapp;

public class FavModel {
    int favLogo;
    String favModule;
    public FavModel(int favLogo, String favModule){
        this.favLogo = favLogo;
        this.favModule = favModule;
    }

    public int getFavLogo(){
        return favLogo;
    }

    public String getFavModule() {
        return favModule;
    }
}
