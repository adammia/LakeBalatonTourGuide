package com.example.kleocida.lakebalatontourguide;

public class Place {

    public final String mID;
    private String mName;
    private int mImage;
    private String mDescription;

    public Place(String ID, String name, int image, String description) {
        mID = ID;
        mName = name;
        mImage = image;
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImage() {
        return mImage;
    }

    public String getDescription() {
        return mDescription;
    }

}
