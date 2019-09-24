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
public class DineIn extends Restaurant {

    private double timeLimit;

    /**
     * Constructor for a dine in restaurant
     * @param name Restaurant's name
     * @param longitude Restaurant's longitude
     * @param latitude Restaurant's latitude
     * @param arrayRating Restaurant's ratings stored in an array
     * @param review Restaurant's reviews stored in an array
     * @param timeLimit Restaurant's dine in time limit in hours
     */
    public DineIn(String name, double longitude, double latitude, double[] arrayRating, String[] review, double timeLimit) {
        super(name, longitude, latitude, arrayRating, review);
        this.timeLimit = timeLimit;
    }

    /**
     * Gets the restaurant's time limit in hours
     * @return restaurant's time limit in hours
     */
    public double getTimeLimit() {
        return timeLimit;
    }

    /**
     * Changes the restaurant's time limit
     * @param newTimeLimit new time limit
     */
    public void editTimeLimit(double newTimeLimit) {
        this.timeLimit = newTimeLimit;
    }

    /**
     * Prints out the information of a take out restaurant
     * @return information of a restaurant
     */
    @Override
    public String toString() {
        return "Name: " + getName() + " | " + "Rating: " + Rating() + " | " + "Time Limit: " + timeLimit + " hours"
                + "\nReviews: " + Reviews() + "\n";
    }

}
