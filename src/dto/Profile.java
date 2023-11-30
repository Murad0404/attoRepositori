package dto;

import enums.ProfilStatus;

import java.time.LocalDateTime;

public class Profile {

    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private LocalDateTime created_date;
    private ProfilStatus status;
    private ProfilStatus role;

    public Profile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public ProfilStatus getStatus() {
        return status;
    }

    public void setStatus(ProfilStatus status) {
        this.status = status;
    }

    public ProfilStatus getRole() {
        return role;
    }

    public void setRole(ProfilStatus role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", created_date=" + created_date +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}
