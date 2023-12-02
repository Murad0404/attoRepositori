package controller;

import db_Util.Database_Util;
import dto.Profile;
import service.ProfileService;

import java.util.Scanner;

public class MainController {

    public static Scanner scanner = new Scanner(System.in);

    public void start() {
        Database_Util databaseUtil = new Database_Util();
        databaseUtil.createTable();
        databaseUtil.createTableCards();
        //databaseUtil.createAdmin();
        boolean t = true;
        while (t) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;

                case 0:
                    t = false;
                    break;
                default:
                    System.out.println("Mazgi");
                    t = false;

            }
        }
    }

    public int getAction() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        return action;
    }

    public void showMenu() {
        System.out.println("***** Menu *****");
        System.out.println("1. Login: ");
        System.out.println("2. Registration: ");
    }

    public void login() {
        System.out.println("Enter phone: ");
        String phone = scanner.next();

        System.out.println("Enter pswd: ");
        String password = scanner.next();

        ProfileService profileService = new ProfileService();
        profileService.searchProfileLogin(password, phone);
    }

    public void registration() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surName = scanner.next();
        System.out.println("Enter phone");
        String phone = scanner.next();
        System.out.println("Enter pswd");
        String password = scanner.next();

        Profile profile = new Profile();
        profile.setName(name);
        profile.setSurname(surName);
        profile.setPhone(phone);
        profile.setPassword(password);
        ProfileService profileService = new ProfileService();
        profileService.addProfile(profile);
    }
}
