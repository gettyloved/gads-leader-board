package com.dvilson.gadsleaderboard.models;

public class User {
    private String name;
    private String hours;
    private String country;
    private String image;
    private  int  score ;


    public User(String name, String hours, String country) {
        this.name = name;
        this.hours = hours;
        this.country = country;
    }



    public User(String name,int score,String country) {
        this.name = name;
        this.country = country;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
