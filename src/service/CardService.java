package service;

import dto.Card;
import enums.CardStatus;
import repository.CardRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CardService {
    public void registrationCardUser(Card card) {
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.search(card.getNumber()));
        Card cards = dtoList.get(0);
        if (card.getExp_date().equals(cards.getExp_date())) {
            if (cards.getStatus().equals(CardStatus.NOT_ACTIVE)) {
                cardRepository.cardChangeStatus_ACTIVE(cards.getId());
            }
        }
    }

    public void cardList() {
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.getAllID(ProfileService.profileGolobal));

        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getStatus().equals(CardStatus.ACTIVE)) {
                System.out.println(dtoList.get(i));
            }
        }
    }

    public void cardAllList() {
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.getAll());
        for (int i = 0; i < dtoList.size(); i++) {
            System.out.println(dtoList.get(i));
        }
    }

    public void searchCardStatusChange(String number) {
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.search(number));
        Card card = dtoList.get(0);
        if (card.getStatus().equals(CardStatus.ACTIVE)) {
            cardRepository.cardChangeStatus_BLOCE(card.getId());
        } else {
            cardRepository.cardChangeStatus_ACTIVE(card.getId());
        }
    }
}
