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
public class TakeOut extends Restaurant {

    private double avgCookTime;

    /**
     * Constructor for a take out restaurant
    * @param name Restaurant's name
     * @param longitude Restaurant's longitude
     * @param latitude Restaurant's latitude
     * @param arrayRating Restaurant's ratings stored in an array
     * @param review Restaurant's reviews stored in an array
     * @param avgCookTime Restaurant's average cook time in minutes
     */
    public TakeOut(String name, double longitude, double latitude, double[] arrayRating, String[] review, double avgCookTime) {
        super(name, longitude, latitude, arrayRating, review);
        this.avgCookTime = avgCookTime;
    }

    /**
     * Gets the restaurant's average cook time in minutes
     * @return average cook time in minutes
     */
    public double getAvgCookTime() {
        return avgCookTime;
    }

    /**
     * Changes the average cook time 
     * @param newAvgCookTime new average cook time
     */
    public void editAvgCookTime(double newAvgCookTime) {
        this.avgCookTime = newAvgCookTime;
    }

    /**
     * Prints out the information of a take out restaurant
     * @return information of a restaurant
     */
    @Override
    public String toString() {
        return "Name: " + getName() + " | " + "Rating: " + Rating() + " | " + "Average Cook Time: " + avgCookTime + " minutes"
                + "\nReviews: " + Reviews() + "\n";
    }

}
