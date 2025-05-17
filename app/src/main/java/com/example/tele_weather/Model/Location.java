package com.example.tele_weather.Model;

public class Location {
    private String id;
    private String name;
    private String region;
    private String country;
    private String lat;
    private String lon;

    private String url;

    public Location(String id, String name, String region, String country, String lat, String lon, String url) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.url = url;
    }

    public String getName() { return name; }
    public String getRegion() { return region; }
    public String getCountry() { return country; }
    public String getLat() { return lat; }
    public String getLon() { return lon; }

    public String getUrl() {return url; }
    public String getId() { return id; }
}
