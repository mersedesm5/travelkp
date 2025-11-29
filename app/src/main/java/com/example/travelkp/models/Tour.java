package com.example.travelkp.models;

import java.util.List;

public class Tour {
    private int id;
    private String title;
    private int durationDays;
    private double price;
    private String currency;
    private double rating;
    private String difficulty;
    private List<String> includes;
    private String image;
    private List<Integer> cities;

    // Default constructor (required for Gson/Retrofit)
    public Tour() {
    }

    public Tour(int id, String title, int durationDays, double price,
                String currency, double rating, String difficulty,
                List<String> includes, String image, List<Integer> cities) {
        this.id = id;
        this.title = title;
        this.durationDays = durationDays;
        this.price = price;
        this.currency = currency;
        this.rating = rating;
        this.difficulty = difficulty;
        this.includes = includes;
        this.image = image;
        this.cities = cities;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getDurationDays() { return durationDays; }
    public double getPrice() { return price; }
    public String getCurrency() { return currency; }
    public double getRating() { return rating; }
    public String getDifficulty() { return difficulty; }
    public List<String> getIncludes() { return includes; }
    public String getImage() { return image; }
    public List<Integer> getCities() { return cities; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }
    public void setPrice(double price) { this.price = price; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setRating(double rating) { this.rating = rating; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setIncludes(List<String> includes) { this.includes = includes; }
    public void setImage(String image) { this.image = image; }
    public void setCities(List<Integer> cities) { this.cities = cities; }
}