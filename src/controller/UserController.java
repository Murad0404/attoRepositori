package controller;

import dto.Card;
import repository.CardRepository;
import repository.ProfileRepasitory;
import service.CardService;
import service.ProfileService;

import java.util.Scanner;

public class UserController {
    public static Scanner scanner = new Scanner(System.in);

    public void start() {

        boolean t = true;
        while (t) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    registrationCard();
                    break;
                case 2:
                    CardService cardServicer = new CardService();
                    cardServicer.cardList();
                    break;
                case 3:
                    cardChangeStatus();
                    break;
                case 4:
                    deleteCard();
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
        System.out.println("***** Menu *****");
        System.out.println("1. Add Card ");
        System.out.println("2. Card List: ");
        System.out.println("3. Card Change Status: ");
        System.out.println("4. Delete Card: ");
        System.out.println("0. Exit: ");
    }
    public void registrationCard() {
        System.out.println("Enter number");
        String number = scanner.next();
        System.out.println("Enter exp_date");
        String exp_date = scanner.next();

        Card card = new Card();
        card.setNumber(number);
        card.setExp_date(exp_date);

        CardService cardServicer = new CardService();
        cardServicer.registrationCardUser(card);
    }
    public void cardChangeStatus(){
        System.out.println("card raqam kiriting : ");
        String numberCard = scanner.next();
        CardService cardServicer = new CardService();
        cardServicer.searchCardStatusChange(numberCard);

    }

    public void deleteCard(){
        System.out.println("card ni o'chirish: ");
        String numberCard = scanner.next();
        CardRepository cardRepository = new CardRepository();
        cardRepository.delete(numberCard);

    }
}
