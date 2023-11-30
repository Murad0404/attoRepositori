package service;

import controller.UserController;
import dto.Card;
import dto.Profile;
import enums.CardStatus;
import repository.CardRepository;
import repository.ProfileRepasitory;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CardServicer {
    public void addCard(Card card) {
        card.setCreated_date(LocalDateTime.now());
        card.setStatus(CardStatus.ACTIVE);
        card.setProfile_id(ProfileService.profileGolobal);

        CardRepository cardRepository = new CardRepository();
        cardRepository.create(card);
    }

    public void cardList(){
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.getAll(ProfileService.profileGolobal));
        for (int i = 0; i < dtoList.size(); i++) {
            System.out.println(dtoList.get(i));
        }
    }

    public void searchCardStatusChange(String number){
        CardRepository cardRepository = new CardRepository();
        List<Card> dtoList = new LinkedList<>(cardRepository.search(number));
        Card card = dtoList.get(0);
        if (card.getStatus().equals(CardStatus.ACTIVE)){
            cardRepository.cardChangeStatus_BLOCE(card.getId());
        }else {
            cardRepository.cardChangeStatus_ACTIVE(card.getId());
        }
    }
}
