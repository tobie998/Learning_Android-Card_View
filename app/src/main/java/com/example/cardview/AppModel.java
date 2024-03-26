package com.example.cardview;

public class AppModel {

    // declare variables
    String name;
    int numOfDownload;
    int thumbnail;

    public AppModel(String name, int numOfDownload, int thumbnail) {
        this.name = name;
        this.numOfDownload = numOfDownload;
        this.thumbnail = thumbnail;
    }

    public AppModel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfDownload() {
        return numOfDownload;
    }

    public void setNumOfDownload(int numOfDownload) {
        this.numOfDownload = numOfDownload;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
