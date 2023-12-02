package dto;

import enums.TerminalStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Terminal {

    private int id;
   private UUID code;
   private String address;
   private TerminalStatus status;
   private LocalDateTime created_date;

    public Terminal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TerminalStatus getStatus() {
        return status;
    }

    public void setStatus(TerminalStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "id=" + id +
                ", code=" + code +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", created_date=" + created_date +
                '}';
    }
}
