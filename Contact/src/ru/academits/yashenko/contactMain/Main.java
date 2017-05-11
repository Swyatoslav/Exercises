package ru.academits.yashenko.contactMain;

import ru.academits.yashenko.contact.Contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact contact1 = new Contact();
        Contact contact2 = new Contact("Ященко", "Святослав", "8-913-458-04-58");

        System.out.print("Введите Фамилию: ");
        contact1.setSurname(scanner.nextLine());
        System.out.print("Введите имя: ");
        contact1.setName(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        contact1.setPhoneNumber(scanner.nextLine());
        System.out.println();

        System.out.println("Карточка 1");
        System.out.printf("Имя: %s%nФамилия: %s%nТелефон: %s%n",
                contact1.getSurname(), contact1.getName(), contact1.getPhoneNumber());
        System.out.println();

        System.out.println("Карточка 2");
        System.out.printf("Имя: %s%nФамилия: %s%nТелефон: %s%n",
                contact2.getSurname(), contact2.getName(), contact2.getPhoneNumber());

    }
}
