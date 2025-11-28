package com.example.travelkp.models;

public class Hotel {
    private int id;
    private int cityId;
    private String name;
    private int stars;
    private double rating;
    private double pricePerNight;
    private String currency;
    private String address;
    private String image;
    private double lat;
    private double lng;

    // Constructor
    public Hotel() {
    }

    public Hotel(int id, int cityId, String name, int stars, double rating,
                 double pricePerNight, String currency, String address,
                 String image, double lat, double lng) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.stars = stars;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
        this.address = address;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public double getRating() {
        return rating;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}