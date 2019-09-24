/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banikaritra_morfood;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aritr
 */
public class BanikAritra_MorFood {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Prints out dashes
     */
    public static void dashes() {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Restaurant> restList = new ArrayList<>();
        Sort a = new Sort(restList);
        a.loadRestList("RestList.txt");
        a.loadAdminList("AdminList.txt");
        boolean run1 = true;
        System.out.println("--------------------------------------------Welcome to MorFood!--------------------------------------------");
        while (run1 != false) { // Main Menu
            boolean run2 = true;
            boolean run3 = true;
            boolean run4 = true;
            boolean run5 = true;
            boolean run6 = true;
            dashes();
            System.out.println("Please select your position(type in the number): ");
            System.out.println("0.Exit Program");
            System.out.println("1.Admin");
            System.out.println("2.User");
            dashes();
            int position;
            try {
                position = Integer.parseInt(in.nextLine());
                if (position > 2 || position < 0) {
                    System.out.println("Please type an integer from the following list");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type an integer from the following list");
                position = 3;
            }
            switch (position) {
                case 0:
                    run1 = false;
                    break;
                case 1:
                    System.out.print("Username:");
                    String username = in.nextLine();
                    System.out.print("Password:");
                    String password = in.nextLine();
                    if (a.checkAdmin(in, username, password) == true) {
                        Admin x = new Admin(username, password);
                        while (run2 != false) { // Admin Menu
                            dashes();
                            System.out.println("What would you like to do today(type in the number): ");
                            System.out.println("0.Previous Menu");
                            System.out.println("1.Add a restaurant");
                            System.out.println("2.Delete a restaurant");
                            System.out.println("3.Edit a restaurant");
                            System.out.println("4.Save restaurant list");
                            dashes();
                            int adminAnswer;
                            try {
                                adminAnswer = Integer.parseInt(in.nextLine());
                                if (adminAnswer > 4 || adminAnswer < 0) {
                                    System.out.println("Please type an integer from the following list");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please type an integer from the following list");
                                adminAnswer = 5;
                            }
                            switch (adminAnswer) {
                                case 0:
                                    run2 = false;
                                    break;
                                case 1:
                                    while (run3 != false) {
                                        dashes();
                                        System.out.println("Which type of restaurant would you like to add(type in the number): ");
                                        System.out.println("0.Previous Menu");
                                        System.out.println("1.Delivery");
                                        System.out.println("2.Dine In");
                                        System.out.println("3.Take out");
                                        dashes();
                                        int type;
                                        try {
                                            type = Integer.parseInt(in.nextLine());
                                            if (type > 3 || type < 0) {
                                                System.out.println("Please type an integer from the following list");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Please type an integer from the following list");
                                            type = 4;
                                        }
                                        switch (type) {
                                            case 0:
                                                run3 = false;
                                                break;
                                            case 1:
                                                x.addDelivery(in, a);
                                                break;
                                            case 2:
                                                x.addDineIn(in, a);
                                                break;
                                            case 3:
                                                x.addTakeOut(in, a);
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    x.deleteRestaurant(in, a);
                                    break;
                                case 3:
                                    x.editRestaurant(in, a);
                                    break;
                                case 4:
                                    a.saveRestList("RestList.txt");
                                    System.out.println("Restaurant list has been saved");
                            }
                        }
                    } else {
                        System.out.println("Your username/password is wrong. Don't forget that the password is case sensitive");
                    }
                    break;
                case 2:
                    String name = "";
                    double longitude = 0;
                    double latitude = 0;

                    System.out.println("Name:");
                    name = in.nextLine();

                    System.out.println("Longitude:");
                    try {
                        longitude = Double.parseDouble(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid entry");
                        break;
                    }

                    System.out.println("Latitude:");
                    try {
                        latitude = Double.parseDouble(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid entry");
                        break;
                    }

                    User y = new User(name, longitude, latitude);

                    while (run4 != false) { // User Menu
                        dashes();
                        System.out.println("What would you like to do today(type in the number): ");
                        System.out.println("0.Previous menu");
                        System.out.println("1.View user information");
                        System.out.println("2.Edit user information");
                        System.out.println("3.Print restaurants");
                        System.out.println("4.Search restaurants");
                        System.out.println("5.Show nearby restaurants");
                        System.out.println("6.Add a rating");
                        System.out.println("7.Add a review");
                        dashes();
                        int userAnswer;
                        try {
                            userAnswer = Integer.parseInt(in.nextLine());
                            if (userAnswer > 7 || userAnswer < 0) {
                                System.out.println("Please type an integer from the following list");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please type an integer from the following list");
                            userAnswer = 8;
                        }
                        switch (userAnswer) {
                            case 0:
                                run4 = false;
                                break;
                            case 1:
                                System.out.println(y);
                                break;
                            case 2:
                                while (run5 != false) {
                                    dashes();
                                    System.out.println("Which one of the following would you like to change(type in the number): ");
                                    System.out.println("0.Previous menu");
                                    System.out.println("1.Name");
                                    System.out.println("2.Longitude");
                                    System.out.println("3.Latitude");
                                    dashes();
                                    int change;
                                    try {
                                        change = Integer.parseInt(in.nextLine());
                                        if (change > 3 || change < 0) {
                                            System.out.println("Please type an integer from the following list");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Please type an integer from the following list");
                                        change = 4;
                                    }
                                    switch (change) {
                                        case 0:
                                            run5 = false;
                                            break;
                                        case 1:
                                            System.out.print("Enter the new name:");
                                            String newName = in.nextLine();
                                            y.editName(newName);
                                            break;
                                        case 2:
                                            System.out.print("Enter the new longitude:");
                                            double newLongitude = Double.parseDouble(in.nextLine());
                                            y.editLongitude(newLongitude);
                                            break;
                                        case 3:
                                            System.out.print("Enter the new latitude:");
                                            double newLatitude = Double.parseDouble(in.nextLine());
                                            y.editLatitude(newLatitude);
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                y.printRest(in, a);
                                break;
                            case 4:
                                y.searchNameRest(in, a);
                                break;
                            case 5:
                                System.out.print("Enter the radius:");
                                double radius = Double.parseDouble(in.nextLine());
                                y.searchNearby(in, a, radius);
                                break;
                            case 6:
                                y.addRating(in, a);
                                break;
                            case 7:
                                y.addReview(in, a);
                                break;
                        }
                    }
                    break;

            }
        }
    }
}
