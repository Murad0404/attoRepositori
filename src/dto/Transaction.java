package dto;

import enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private Card card_number;
    private double amount;
    private Terminal terminal_code;
    private TransactionType transactionType;
     private LocalDateTime created_date;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCard_number() {
        return card_number;
    }

    public void setCard_number(Card card_number) {
        this.card_number = card_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Terminal getTerminal_code() {
        return terminal_code;
    }

    public void setTerminal_code(Terminal terminal_code) {
        this.terminal_code = terminal_code;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", card_number=" + card_number +
                ", amount=" + amount +
                ", terminal_code=" + terminal_code +
                ", transactionType=" + transactionType +
                ", created_date=" + created_date +
                '}';
    }
}
