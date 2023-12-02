package controller;

import dto.Card;
import repository.ProfileRepasitory;
import service.AdminService;
import service.CardService;
import service.ProfileService;

import java.util.Scanner;

public class AdminController {
    public static Scanner scanner = new Scanner(System.in);

    public void start() {

        boolean t = true;
        while (t) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    createCard();
                    break;
                case 2:
                    CardService cardService = new CardService();
                    cardService .cardAllList();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    ProfileRepasitory profileRepasitory =new ProfileRepasitory();
                    profileRepasitory.loginUpdateStatusNOT_AKTIVE(ProfileService.profileGolobal);
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
        System.out.println("***** Admine MENU *****");
        System.out.println("1. Create Card: ");
        System.out.println("2. Card List: ");
        System.out.println("3. Update Card: ");
        System.out.println("4. Change Card status: ");
        System.out.println("5. Delete Card: ");
        System.out.println("0. Exit: ");
    }


    public void cardChangeStatus(){
        System.out.println("card raqam kiriting : ");
        String numberCard = scanner.next();
        CardService cardService = new CardService();
        cardService.searchCardStatusChange(numberCard);
    }

    public void createCard() {
        System.out.println("Enter number");
        String number = scanner.next();
        System.out.println("Enter exp_date");
        String exp_date = scanner.next();
        System.out.println("Enter balance");
        double balance = scanner.nextDouble();
        System.out.println("Enter phone");
        String phone = scanner.next();
        Integer user_id = scanner.nextInt();

        Card card = new Card();
        card.setNumber(number);
        card.setExp_date(exp_date);
        card.setBalance(balance);
        card.setPhone(phone);
        card.setProfile_id(user_id);

        AdminService adminService = new AdminService();
        adminService.addCard(card);
    }
}
