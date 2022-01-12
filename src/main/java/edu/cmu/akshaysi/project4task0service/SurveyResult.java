package edu.cmu.akshaysi.project4task0service;

public class SurveyResult {
    private double sampleSize;
    private String age;
    private String country;
    private String education;
    private String gender;
    private int resultsCount;
    private String surveyOutcome;

    public String getSurveyOutcome() {
        return surveyOutcome;
    }

    public void setSurveyOutcome(String surveyOutcome) {
        this.surveyOutcome = surveyOutcome;
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

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    @Override
    public String toString() {
        return "SurveyResult{" +
                "sampleSize=" + sampleSize +
                ", resultsCount=" + resultsCount +
                ", surveyResult= " + surveyOutcome +
                '}';
    }
}
