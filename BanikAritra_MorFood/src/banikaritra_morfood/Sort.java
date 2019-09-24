/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banikaritra_morfood;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author aritr
 */
public class Sort {

    ArrayList<Restaurant> restList = new ArrayList<>();
    ArrayList<Admin> adminList = new ArrayList<>();

    /**
     * Constructor for a sorter
     * @param restList list of all the restaurants in the database
     */
    public Sort(ArrayList<Restaurant> restList) {
        this.restList = restList;
    }

    /**
     * Prints all the restaurants in the database
     */
    public void printAll() {
        for (Restaurant i : restList) {
            System.out.println(i);;
        }
    }

    /**
     * Sorts the restaurants based on distance 
     * @param userLongitude the user's longitude
     * @param userLatitude the user's latitude
     * @return restaurant list sorted based on distance
     */
    public ArrayList<Restaurant> sortNearby(double userLongitude, double userLatitude) {
        Restaurant placeholder;
        boolean swapped;
        for (int i = 0; i < restList.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < restList.size() - i - 1; j++) {
                if (restList.get(j).Distance(userLongitude, userLatitude) > restList.get(j + 1).Distance(userLongitude, userLatitude)) {
                    placeholder = restList.get(j);
                    restList.set(j, restList.get(j + 1));
                    restList.set(j + 1, placeholder);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return restList;
    }

    /**
     * Sorts the restaurants based on rating
     * @return restaurant list sorted based on rating
     */
    public ArrayList<Restaurant> sortRating() {
        Restaurant placeholder;
        boolean swapped = false;
        for (int i = 0; i < restList.size() - 1; i++) {
            for (int j = 0; j < restList.size() - i - 1; j++) {
                if (restList.get(j).Rating() < restList.get(j + 1).Rating()) {
                    placeholder = restList.get(j);
                    restList.set(j, restList.get(j + 1));
                    restList.set(j + 1, placeholder);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return restList;
    }

    /**
     * Sorts the restaurants alphabetically
     * @return restaurant list sorted alphabetically
     */
    public ArrayList<Restaurant> sortName() {
        Collections.sort(restList);
        return restList;
    }

    /**
     * Saves restaurant list in a CSV file
     * @param filename name of the CSV file
     */
    public void saveRestList(String filename) {
        try {
            File f = new File("src/BanikAritra_MorFood/" + filename);
            FileWriter out = new FileWriter(f);
            for (Restaurant i : restList) {
                if (i instanceof Delivery) {
                    out.write(i.getName() + "," + i.getLongitude() + "," + i.getLatitude() + ","
                            + "Delivery" + "," + ((Delivery) i).getDeliveryBaseFee() + "," + ((Delivery) i).getDeliveryFare());
                    out.write("\n");
                }
                if (i instanceof TakeOut) {
                    out.write(i.getName() + "," + i.getLongitude() + "," + i.getLatitude() + ","
                            + "Take Out" + "," + ((TakeOut) i).getAvgCookTime());
                    out.write("\n");
                }
                if (i instanceof DineIn) {
                    out.write(i.getName() + "," + i.getLongitude() + "," + i.getLatitude() + ","
                            + "Dine In" + "," + ((DineIn) i).getTimeLimit());
                    out.write("\n");
                }
            }
            out.close();
        } catch (IOException iox) {
            System.out.println("Error opening " + filename);
        }
    }

    /**
     * Loads the restaurant information from a CSV file
     * @param filename name of the CSV file
     */
    public void loadRestList(String filename) {
        String line;
        Restaurant x;
        String name;
        String longitude;
        String latitude;
        double array[] = new double[0];
        String review[] = new String[0];

        try {
            Scanner in = new Scanner(new File("src/BanikAritra_MorFood/" + filename));

            while (in.hasNext()) {
                line = in.nextLine();
                String list[];
                list = new String[7];
                list = line.split(",");

                name = list[0];
                longitude = list[1];
                latitude = list[2];

                if (line.contains("Delivery")) {
                    x = new Delivery(name, Double.parseDouble(longitude), Double.parseDouble(latitude),
                            array, review, Double.parseDouble(list[4]), Double.parseDouble(list[5]));
                    restList.add(x);
                }
                if (line.contains("Take Out")) {
                    x = new TakeOut(name, Double.parseDouble(longitude), Double.parseDouble(latitude),
                            array, review, Double.parseDouble(list[4]));
                    restList.add(x);

                }
                if (line.contains("Dine In")) {
                    x = new DineIn(name, Double.parseDouble(longitude), Double.parseDouble(latitude),
                            array, review, Double.parseDouble(list[4]));
                    restList.add(x);

                }

            }
            in.close();
            System.out.println("File has successfully opened\n");
        } catch (IOException iox) {
            System.out.println("Error opening " + filename);
        }

    }

    /**
     * Loads the admin list from a CSV file
     * @param filename name of the CSV file
     */
    public void loadAdminList(String filename) {
        String line;
        Admin x;
        try {
            Scanner in = new Scanner(new File("src/BanikAritra_MorFood/" + filename));
            while (in.hasNext()) {
                line = in.nextLine();
                String list[];
                list = new String[2];
                list = line.split(",");
                x = new Admin(list[0], list[1]);
                adminList.add(x);
            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Error opening " + filename);
        }
    }

    /**
     * Checks the login information of an administrator
     * @param in Scanner 
     * @param username username of the administrator
     * @param password password of the administrator
     * @return whether or not the username and password are valid
     */
    public boolean checkAdmin(Scanner in, String username, String password) {
        Admin x = new Admin(username, password);
        for (Admin i : adminList) {
            if (x.getUsername().equalsIgnoreCase(i.getUsername()) && x.getPassword().equals(i.getPassword())) {
                return true;
            }
        }

        return false;

    }

}
