package com.ildreamteamjsx.azzurrinet;

public class Team {

    String name;
    String city;
    String link;
    int image;
    String color;
    String desc;

    public Team(String name, String link, int image, String city, String color, String desc) {
        this.name = name;
        this.link = link;
        this.image = image;
        this.city = city;
        this.color = color;
        this.desc = desc;
    }
}
