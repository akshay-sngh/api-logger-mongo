package edu.cmu.akshaysi.project4task0service;

import java.util.ArrayList;
import java.util.List;

public class LocationsWouldAttend
{
    private double sampleSize;
    private String age;
    private String country;
    private String education;
    private String gender;
    private List<Location> locations;
    private int resultsCount;

    public LocationsWouldAttend() {
        locations = new ArrayList<>();
    }

    public double getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(double sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    @Override
    public String toString() {
        return "LocationsWouldAttend{" +
                "sampleSize=" + sampleSize +
                ", locations=" + locations +
                ", resultsCount=" + resultsCount +
                '}';
    }
}
