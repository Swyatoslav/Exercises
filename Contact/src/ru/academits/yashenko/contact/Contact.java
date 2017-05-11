package ru.academits.yashenko.contact;

public class Contact {
    private String surname;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String surname, String name, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
