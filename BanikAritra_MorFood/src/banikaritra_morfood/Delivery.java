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
public class Delivery extends Restaurant {

    private double deliveryBaseFee;
    private double deliveryFare;

    /**
     * Constructor for a Delivery Restaurant
     * @param name Restaurant's name
     * @param longitude Restaurant's longitude 
     * @param latitude Restaurant's latitude
     * @param arrayRating Restaurant's ratings stored in an array
     * @param review Restaurant's reviews stored in an array
     * @param deliveryBaseFee Restaurant's delivery base fee
     * @param deliveryFare Restaurant's delivery fare per km
     */
    public Delivery(String name, double longitude, double latitude, double[] arrayRating, String[] review, double deliveryBaseFee, double deliveryFare) {
        super(name, longitude, latitude, arrayRating, review);
        this.deliveryBaseFee = deliveryBaseFee;
        this.deliveryFare = deliveryFare;
    }

    /**
     * Gets the delivery base fee
     * @return delivery base fee
     */
    public double getDeliveryBaseFee() {
        return deliveryBaseFee;
    }

    /**
     * Gets the delivery fare per km
     * @return delivery fare per km
     */
    public double getDeliveryFare() {
        return deliveryFare;
    }

    /**
     * Changes the delivery base fee
     * @param DeliveryBaseFee new delivery base fee
     */
    public void editDeliveryBaseFee(double DeliveryBaseFee) {
        this.deliveryBaseFee = DeliveryBaseFee;
    }

    /**
     * Changes the deliver far per km
     * @param deliveryFare new delivery fare per km
     */
    public void editDeliveryFare(double deliveryFare) {
        this.deliveryFare = deliveryFare;
    }

    /**
     * Prints out the information of a delivery restaurant
     * @return information of the restaurant
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "Rating: " + Rating() + " | " + "Base Delivery Fee: $" + deliveryBaseFee + " | "
                + "Delivery Fare(per km): $" + deliveryFare + "\nReviews: " + Reviews() + "\n";
    }

}
