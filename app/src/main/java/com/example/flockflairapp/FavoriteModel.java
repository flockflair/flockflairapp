package com.example.flockflairapp;

public class FavoriteModel {

    String FavoriteName;

    public FavoriteModel() {
    }

    public FavoriteModel(String favoriteName) {
        FavoriteName = favoriteName;
    }

    public String getFavoriteName() {
        return FavoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        FavoriteName = favoriteName;
    }
}
