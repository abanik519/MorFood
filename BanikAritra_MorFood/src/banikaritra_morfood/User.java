/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banikaritra_morfood;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aritr
 */
public class User {

    private String name;
    private double longitude;
    private double latitude;

    /**
     * Constructor for a user
     * @param name User's name
     * @param longitude User's longitude
     * @param latitude  User's latitude
     */
    public User(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Gets the name of a user
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the longitude of a user
     * @return user's longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the latitude of a user
     * @return User's latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Changes the name of a user
     * @param newName new name 
     */
    public void editName(String newName) {
        this.name = newName;
    }

    /**
     * Changes the longitude of a user
     * @param newLongitude new longitude
     */
    public void editLongitude(double newLongitude) {
        this.longitude = newLongitude;
    }

    /**
     * Changes the latitude of a user
     * @param newLatitude new latitude
     */
    public void editLatitude(double newLatitude) {
        this.latitude = newLatitude;
    }

    /**
     * Prints a list of restaurants based on user's choice
     * @param in Scanner
     * @param a Sort
     */
    public void printRest(Scanner in, Sort a) {
        boolean run = true;

        while (run != false) {
            int answer;
            dashes();
            System.out.println("Please choose one of the following options(type in the number): ");
            System.out.println("0.Return to previous menu");
            System.out.println("1.Print all restaurants");
            System.out.println("2.Print alphabetically");
            System.out.println("3.Print based on rating");
            System.out.println("4.Print based on distance");
            dashes();
            try {
                answer = Integer.parseInt(in.nextLine());
                if (answer > 4 || answer < 0) {
                    System.out.println("Please type an integer from the following list");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type an integer from the following list");
                answer = 5;
            }
            switch (answer) {
                case 0:
                    run = false;
                    break;
                case 1:
                    a.printAll();
                    break;
                case 2:
                    a.sortName();
                    a.printAll();
                    break;
                case 3:
                    a.sortRating();
                    a.printAll();
                    break;
                case 4:
                    a.sortNearby(longitude, latitude);
                    a.printAll();
                    break;
            }
        }

    }

    /**
     * Searches the name of a restaurant
     * @param in Scanner 
     * @param a Sort
     */
    public void searchNameRest(Scanner in, Sort a) {
        boolean searched = false;
        dashes();
        System.out.println("Type the name of the restaurant: ");
        String name = in.nextLine();
        for (Restaurant i : a.restList) {
            if (i.getName().equalsIgnoreCase(name)) {
                System.out.println(i);
                searched = true;
            }
        }
        if (searched == false) {
            System.out.println("Sorry, that restaurant is not saved.");
        }
    }

    /**
     * Searches for nearby restaurants based on the radius inputed by the user
     * @param in Scanner
     * @param a Sort
     * @param radius radius inputed by the user 
     */
    public void searchNearby(Scanner in, Sort a, double radius) {
        int counter = 0;
    	a.sortNearby(longitude, latitude);
        for (Restaurant i : a.restList) {
            if (i.Distance(longitude, latitude) < radius) {
                System.out.println(i);
                counter += 1;
            }
        }
        if(counter == 0) {
        	System.out.println("Sorry there are no restaurants nearby.");
        }
    }

    /**
     * Adds a rating to a restaurant
     * @param in Scanner
     * @param a Sort
     */
    public void addRating(Scanner in, Sort a) {
        System.out.println("Type the name of the restaurant: ");
        String name = in.nextLine();
        boolean found = false;
        for (Restaurant i : a.restList) {
            if (i.getName().equalsIgnoreCase(name)) {
                found = true;

                System.out.println("Type the rating(1-5): ");
                int rating;
                try {
                    rating = Integer.parseInt(in.nextLine());
                    if (rating > 5 || rating < 1) {
                        System.out.println("Invalid entry");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry");
                    break;

                }
                int currentSize = i.getArrayRating().length;
                int newSize = currentSize + 1;
                double[] oldRating = i.getArrayRating();
                double[] newRating = new double[newSize];
                for (int j = 0; j < currentSize; j++) {
                    newRating[j] = oldRating[j];
                }
                newRating[newSize - 1] = rating;
                i.editRating(newRating);
            }
        }
        if (found == false) {
            System.out.println("Sorry, that restaurant doesn't exist");
        }
    }

    /**
     * Adds a review to a restaurant
     * @param in Scanner
     * @param a Sort
     */
    public void addReview(Scanner in, Sort a) {
        System.out.println("Type the name of the restaurant: ");
        String name = in.nextLine();
        boolean found = false;
        for (Restaurant i : a.restList) {
            if (i.getName().equalsIgnoreCase(name)) {
                System.out.println("Type the review: ");
                String review = in.nextLine();
                int currentSize = i.getReview().length;
                int newSize = currentSize + 1;
                String[] oldReview = i.getReview();
                String[] newReview = new String[newSize];
                for (int j = 0; j < currentSize; j++) {
                    newReview[j] = oldReview[j];
                }
                newReview[newSize - 1] = review;
                i.editReview(newReview);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Sorry, that restaurant doesn't exist");
        }

    }

    /**
     * Prints out the information of a user
     * @return user's information
     */
    public String toString() {
        return "Name: " + name + " | " + "Longitude: " + longitude + " | " + "Latitude :" + latitude + "\n";
    }

    /**
     * Prints out dashes
     */
    public static void dashes() {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

}
