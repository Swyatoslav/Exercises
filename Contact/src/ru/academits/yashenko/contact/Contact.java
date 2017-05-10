package ru.academits.yashenko.contact;

class Contact {
    private String surname;
    private String name;
    private String phoneNumber;

    Contact() {
    }

    Contact(String surname, String name, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
