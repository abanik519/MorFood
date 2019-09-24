/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banikaritra_morfood;

/**
 *
 * @author aritr
 */
public class Restaurant implements Comparable<Restaurant> {

    private String name;
    private double longitude;
    private double latitude;
    private double[] arrayRating;
    private String[] review;

    /**
     * Constructor for a restaurant
     *
     * @param name Restaurant's name
     * @param longitude Restaurant's longitude
     * @param latitude Restaurant's latitude
     * @param arrayRating Restaurant's ratings stored in an array
     * @param review Restaurant's reviews stored in an array
     */
    public Restaurant(String name, double longitude, double latitude, double[] arrayRating, String[] review) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.arrayRating = arrayRating;
        this.review = review;
    }

    /**
     * Gets the name of a restaurant
     *
     * @return name of the restaurant
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the longitude of a restaurant
     *
     * @return longitude of the restaurant
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *Gets the latitude of a restaurant
     * @return latitude of the restaurant
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the array filled with ratings for a restaurant
     * @return array filled with ratings for the restaurant
     */
    public double[] getArrayRating() {
        return arrayRating;
    }

    /**
     * Gets the array filled with reviews for a restaurant
     * @return array filled with reviews for a restaurant
     */
    public String[] getReview() {
        return review;
    }

    /**
     * Changes the name of a restaurant
     * @param newName new name
     */
    public void editName(String newName) {
        this.name = newName;
    }

    /**
     * Changes the longitude of a restaurant
     * @param newLongitude new longitude
     */
    public void editLongitude(double newLongitude) {
        this.longitude = newLongitude;
    }

    /**
     * Changes the latitude of a restaurant
     * @param newLatitude new latitude
     */
    public void editLatitude(double newLatitude) {
        this.latitude = newLatitude;
    }

    /**
     * Changes the array containing ratings of a restaurant
     * @param newArrayRating new array containing ratings
     */
    public void editRating(double[] newArrayRating) {
        this.arrayRating = newArrayRating;
    }

    /**
     * Changes the array containing reviews of a restaurant
     * @param newReview new array containing reviews
     */
    public void editReview(String[] newReview) {
        this.review = newReview;
    }

    /**
     * Determines the distance between the user and the restaurant using the Haversine Formula
     * @param userLongitude user's longitude
     * @param userLatitude user's latitude
     * @return 
     */
    public double Distance(double userLongitude, double userLatitude) {
        double R = 6371;
        double a = Math.pow(Math.sin((Math.toRadians(userLatitude - latitude)) / 2), 2) + Math.cos(Math.toRadians(userLatitude))
                * Math.cos(Math.toRadians(latitude)) * Math.pow(Math.sin((Math.toRadians(userLongitude - longitude)) / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    /**
     * Calculates the overall rating for a restaurant
     * @return overall rating
     */
    public double Rating() {
        int sum = 0;
        for (int i = 0; i < arrayRating.length; i++) {
            sum += arrayRating[i];
        }
        if (sum != 0) {
            return sum / arrayRating.length;
        }
        return 0;
    }

    /**
     * Puts all the reviews into a string to get rid of the array brackets
     * @return string containing reviews
     */
    public String Reviews() {
        String reviews = "";
        for (String a : review) {
            reviews += a;
            reviews += "\n";
        }
        if (reviews.equals("")) {
            return "No reviews";
        }
        return reviews;
    }

    /**
     * Compares to restaurants name alphabetically
     * @param a a restaurant
     * @return an integer that defines which one goes first
     */
    @Override
    public int compareTo(Restaurant a) {
        return this.name.compareTo(a.name);
    }

    /**
     * Prints out the information of a restaurant
     * @return information of a restaurant
     */
    @Override
    public String toString() {
        return "Name: " + name + " | " + "Rating: " + Rating() + " | " + "\nReviews: " + Reviews() + "\n";
    }

}
