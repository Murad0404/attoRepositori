package service;

import dto.Card;
import enums.CardStatus;
import repository.CardRepository;

import java.time.LocalDateTime;

public class AdminService {
    public void addCard(Card card) {
        card.setCreated_date(LocalDateTime.now());
        card.setStatus(CardStatus.NOT_ACTIVE);

        CardRepository cardRepository = new CardRepository();
        cardRepository.create(card);
    }
}
