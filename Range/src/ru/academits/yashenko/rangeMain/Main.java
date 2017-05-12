package ru.academits.yashenko.rangeMain;

import ru.academits.yashenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(1.45, 5.74);

        System.out.print("Введите начальную координату: ");
        double from = scanner.nextDouble();
        System.out.print("Введите конечную координату: ");
        double to = scanner.nextDouble();
        Range range2 = new Range(from, to);

        System.out.println("Первый диапазон");
        System.out.printf("Длина: %.2f", range1.getRangeLength());
        System.out.println();
        System.out.print("Введите любое число: ");
        double number = scanner.nextDouble();
        System.out.println(range1.isInside(number) ? "Число входит в диапазон" : "Число не входит в диапазон");
        System.out.println();

        System.out.println("Второй диапазон");
        System.out.printf("Длина: %.2f", range2.getRangeLength());
        System.out.println();
        System.out.print("Введите любое число: ");
        number = scanner.nextDouble();
        System.out.println(range2.isInside(number) ? "Число входит в диапазон" : "Число не входит в диапазон");
        System.out.println();

        Range range3 = new Range(0, 0);
        range3 = range3.getCrossingRange(range1, range2);
        System.out.println("Интервал-пересечение");
        if (range3 == null) {
            System.out.println("Интервалы не пересекаются");
        } else {
            System.out.printf("From: %.2f%nTo: %.2f", range3.getFrom(), range3.getTo());
        }

        Range[] range4;
        Range[] range5;

    }
}
