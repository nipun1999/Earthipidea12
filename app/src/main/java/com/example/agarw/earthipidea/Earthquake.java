package com.example.agarw.earthipidea;

import static android.R.attr.author;

/**
 * Created by agarw on 12/22/2017.
 */

public class Earthquake {
    private String title;
    private String magnitude;
    private String location;
    private String depth;
    private String latitude;
    private String longitude;
    private String date_time;

    public Earthquake(String title, String magnitude, String location, String depth, String latitude, String longitude, String date_time) {
        this.title = title;
        this.magnitude = magnitude;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date_time = date_time;
        this.depth = depth; }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMagnitude() {
            return magnitude;
        }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getDepth() {
        return depth;
    }
    public String getDate_time() {
        return date_time;
    }
    public String getLongitude() {
        return longitude;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setDepth(String depth) {
        this.depth = depth;
    }
    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }


    public Earthquake() {
    }




    }

