/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banikaritra_morfood;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aritr
 */
public class Admin {

    private String username;
    private String password;

    /**
     * Constructor for an administrator
     * @param username admin's username
     * @param password admin's password
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the admin's username
     * @return admin's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the admin's password
     * @return admin's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes the admin's username
     * @param username new username
     */
    public void editUsername(String username) {
        this.username = username;
    }

    /**
     * Changes the admin's password
     * @param password new password
     */
    public void editPassword(String password) {
        this.password = password;
    }

    /**
     * Adds a restaurant that is of type Delivery
     * @param in Scanner 
     * @param a Sort
     */
    public void addDelivery(Scanner in, Sort a) {
        boolean run = true;
        while (run != false) {
            System.out.println("Enter the name: ");
            String name = in.nextLine();

            double longitude = 0;
            System.out.println("Enter the longitude: ");
            try {
                longitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }

            double latitude = 0;
            System.out.println("Enter the latitude: ");
            try {
                latitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }
            double ratings[] = new double[0];

            String reviews[] = new String[0];

            double deliveryBase = 0;
            System.out.println("Enter the delivery base fee: ");
            try {
                deliveryBase = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }

            double deliveryFare = 0;
            System.out.println("Enter the delivery fare: ");
            try {
                deliveryFare = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }

            Restaurant x = new Delivery(name, longitude, latitude, ratings, reviews, deliveryBase, deliveryFare);
            a.restList.add(x);
            break;
        }
    }

    /**
     * Adds a restaurant that is of type DineIn  
     * @param in Scanner
     * @param a Sort
     */
    public void addDineIn(Scanner in, Sort a) {
        boolean run = true;
        while (run != false) {
            System.out.println("Enter the name: ");
            String name = in.nextLine();

            double longitude = 0;
            System.out.println("Enter the longitude: ");
            try {
                longitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }

            double latitude = 0;
            System.out.println("Enter the latitude: ");
            try {
                latitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }
            double ratings[] = new double[0];

            String reviews[] = new String[0];

            int timeLimit = 0;
            System.out.println("Enter the time limit: ");
            try {
                timeLimit = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }
            Restaurant x = new DineIn(name, longitude, latitude, ratings, reviews, timeLimit);
            a.restList.add(x);
            break;
        }
    }

    /**
     * Adds a restaurant that is of type TakeOut
     * @param in Scanner
     * @param a Sort  
     */
    public void addTakeOut(Scanner in, Sort a) {
        boolean run = true;
        while (run != false) {
            System.out.println("Enter the name: ");
            String name = in.nextLine();

            double longitude = 0;
            System.out.println("Enter the longitude: ");
            try {
                longitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }

            double latitude = 0;
            System.out.println("Enter the latitude: ");
            try {
                latitude = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry");
                break;
            }
            double ratings[] = new double[0];

            String reviews[] = new String[0];

            int avgTime = 0;
            System.out.println("Enter the average cook time: ");
            try{
            avgTime = Integer.parseInt(in.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid entry");
                break;
            }
            Restaurant x = new TakeOut(name, longitude, latitude, ratings, reviews, avgTime);
            a.restList.add(x);
        }
    }

    /**
     * Allows the admin to edit any restaurant
     * @param in Scanner
     * @param a Sort
     */
    public void editRestaurant(Scanner in, Sort a) {
        boolean run = true;
        System.out.println("What is the name of the restaurant: ");
        String name = in.nextLine();
        boolean edited = false;
        while (run != false) {
            for (Restaurant i : a.restList) {
                if (i.getName().equalsIgnoreCase(name) && i instanceof Delivery) {
                    edited = true;
                    dashes();
                    System.out.println("What would you like to edit(type in the number):");
                    System.out.println("0.Previous Menu");
                    System.out.println("1.Longitude");
                    System.out.println("2.Latitude");
                    System.out.println("3.Delete Ratings");
                    System.out.println("4.Delete Reviews");
                    System.out.println("5.Delivery Base Fee");
                    System.out.println("6.Delivery Fare");
                    dashes();
                    int answer;
                    try {
                        answer = Integer.parseInt(in.nextLine());
                        if (answer > 6 || answer < 0) {
                            System.out.println("Please type an integer from the following list");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please type an integer from the following list");
                        answer = 7;
                    }
                    switch (answer) {
                        case 0:
                            run = false;
                            break;
                        case 1:
                            System.out.println("Type the new Longitude: ");
                            int newLongitude = Integer.parseInt(in.nextLine());
                            i.editLongitude(newLongitude);
                            break;
                        case 2:
                            System.out.println("Type the new Latitude: ");
                            int newLatitude = Integer.parseInt(in.nextLine());
                            i.editLatitude(newLatitude);
                            break;
                        case 3:
                            if (i.Rating() != 0) {
                                System.out.println(i.getArrayRating());
                                System.out.println("Which rating would you like to delete(type the index of the rating): ");
                                int index = Integer.parseInt(in.nextLine());
                                double newArrayRating[] = i.getArrayRating();
                                for (int j = index; j < newArrayRating.length; j++) {
                                    newArrayRating[j] = newArrayRating[j + 1];
                                }
                                i.editRating(newArrayRating);
                            } else {
                                System.out.println("There are no ratings");
                            }
                            break;
                        case 4:
                            if (!i.Reviews().equals("No reviews")) {
                                System.out.println(i.getReview());
                                System.out.println("Which review would you like to delete(type the index of the review): ");
                                int index2 = Integer.parseInt(in.nextLine());
                                String newReview[] = i.getReview();
                                for (int j = index2; j < newReview.length; j++) {
                                    newReview[j] = newReview[j + 1];
                                }
                                i.editReview(newReview);
                            } else {
                                System.out.println("There are no reviews");
                            }
                            break;
                        case 5:
                            System.out.println("Type the new delivery base fee: ");
                            double fee = Double.parseDouble(in.nextLine());
                            ((Delivery) i).editDeliveryBaseFee(fee);
                            break;
                        case 6:
                            System.out.println("Type the new delivery fare: ");
                            double fare = Double.parseDouble(in.nextLine());
                            ((Delivery) i).editDeliveryFare(fare);
                            break;
                    }
                } else if (i.getName().equalsIgnoreCase(name) && i instanceof TakeOut) {
                    dashes();
                    System.out.println("What would you like to edit(type in the number):");
                    System.out.println("0.Previous Menu");
                    System.out.println("1.Longitude");
                    System.out.println("2.Latitude");
                    System.out.println("3.Ratings");
                    System.out.println("4.Reviews");
                    System.out.println("5.Average cook time");
                    dashes();
                    int answer;
                    try {
                        answer = Integer.parseInt(in.nextLine());
                        if (answer > 5 || answer < 0) {
                            System.out.println("Please type an integer from the following list");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please type an integer from the following list");
                        answer = 6;
                    }
                    switch (answer) {
                        case 0:
                            run = false;
                            break;
                        case 1:
                            System.out.println("Type the new Longitude: ");
                            int newLongitude = Integer.parseInt(in.nextLine());
                            i.editLongitude(newLongitude);
                            break;
                        case 2:
                            System.out.println("Type the new Latitude: ");
                            int newLatitude = Integer.parseInt(in.nextLine());
                            i.editLatitude(newLatitude);
                            break;
                        case 3:
                            if (i.Rating() != 0) {
                                System.out.println(i.getArrayRating());
                                System.out.println("Which rating would you like to delete(type the index of the rating): ");
                                int index = Integer.parseInt(in.nextLine());
                                double newArrayRating[] = i.getArrayRating();
                                for (int j = index; j < newArrayRating.length; j++) {
                                    newArrayRating[j] = newArrayRating[j + 1];
                                }
                                i.editRating(newArrayRating);
                            } else {
                                System.out.println("There are no ratings");
                            }
                            break;
                        case 4:
                            if (!i.Reviews().equals("No reviews")) {
                                System.out.println(i.getReview());
                                System.out.println("Which review would you like to delete(type the index of the review): ");
                                int index2 = Integer.parseInt(in.nextLine());
                                String newReview[] = i.getReview();
                                for (int j = index2; j < newReview.length; j++) {
                                    newReview[j] = newReview[j + 1];
                                }
                                i.editReview(newReview);
                            } else {
                                System.out.println("There are no reviews");
                            }
                            break;
                        case 5:
                            System.out.println("Type the new average cook time: ");
                            double time = Double.parseDouble(in.nextLine());
                            ((TakeOut) i).editAvgCookTime(time);
                            break;
                    }
                } else if (i.getName().equalsIgnoreCase(name) && i instanceof DineIn) {
                    edited = true;
                    dashes();
                    System.out.println("What would you like to edit(type in the number):");
                    System.out.println("0.Previous Menu");
                    System.out.println("1.Longitude");
                    System.out.println("2.Latitude");
                    System.out.println("3.Ratings");
                    System.out.println("4.Reviews");
                    System.out.println("5.Time limit");
                    dashes();
                    int answer;
                    try {
                        answer = Integer.parseInt(in.nextLine());
                        if (answer > 5 || answer < 0) {
                            System.out.println("Please type an integer from the following list");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please type an integer from the following list");
                        answer = 6;
                    }
                    switch (answer) {
                        case 0:
                            run = false;
                            break;
                        case 1:
                            System.out.println("Type the new Longitude: ");
                            int newLongitude = Integer.parseInt(in.nextLine());
                            i.editLongitude(newLongitude);
                            break;
                        case 2:
                            System.out.println("Type the new Latitude: ");
                            int newLatitude = Integer.parseInt(in.nextLine());
                            i.editLatitude(newLatitude);
                            break;
                        case 3:
                            if (i.Rating() != 0) {
                                System.out.println(i.getArrayRating());
                                System.out.println("Which rating would you like to delete(type the index of the rating): ");
                                int index = Integer.parseInt(in.nextLine());
                                double newArrayRating[] = i.getArrayRating();
                                for (int j = index; j < newArrayRating.length; j++) {
                                    newArrayRating[j] = newArrayRating[j + 1];
                                }
                                i.editRating(newArrayRating);
                            } else {
                                System.out.println("There are no ratings");
                            }
                            break;
                        case 4:
                            if (!i.Reviews().equals("No reviews")) {
                                System.out.println(i.getReview());
                                System.out.println("Which review would you like to delete(type the index of the review): ");
                                int index2 = Integer.parseInt(in.nextLine());
                                String newReview[] = i.getReview();
                                for (int j = index2; j < newReview.length; j++) {
                                    newReview[j] = newReview[j + 1];
                                }
                                i.editReview(newReview);
                            } else {
                                System.out.println("There are no reviews");
                            }
                            break;
                        case 5:
                            System.out.println("Type the new time limit: ");
                            double limit = Double.parseDouble(in.nextLine());
                            ((DineIn) i).editTimeLimit(limit);
                            break;
                    }

                }
            }
        }
        if (edited == false) {
            System.out.println("Sorry that restaurant doesn't exist.");
        }

    }

    /**
     * Allows the admin to delete any restaurant
     * @param in Scanner
     * @param a Sort
     */
    public void deleteRestaurant(Scanner in, Sort a) {
        System.out.println("What is the name of the restaurant: ");
        String name = in.nextLine();
        boolean deleted = false;
        for (Restaurant i : a.restList) {
            if (i.getName().equalsIgnoreCase(name)) {
                a.restList.remove(i);
                System.out.println(name + " has been deleted");
                deleted = true;
            }
        }
        if (deleted = false) {
            System.out.println("Sorry, that restaurant is not saved.");
        }
    }

    /**
     * Prints dashes
     */
    public static void dashes() {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    /**
     * Prints out admin's information
     * @return admin's information
     */
    @Override
    public String toString() {
        return username + password;
    }
}
