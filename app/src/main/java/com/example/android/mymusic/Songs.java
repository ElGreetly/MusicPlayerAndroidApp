package com.example.android.mymusic;

/**
 * Created by ElGreetly on 4/8/18.
 */

public class Songs {
    private String name;
    private String artist;
    private String cost;
    public Songs(String nName, String nArtist, String nCost){
        name = nName;
        artist = nArtist;
        cost = nCost;
    }
    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }
    public String getCost(){
        return cost;
    }
}
