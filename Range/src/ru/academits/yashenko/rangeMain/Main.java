package ru.academits.yashenko.rangeMain;

import ru.academits.yashenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(1.45, 5.74);

        System.out.println("Первый диапазон");
        System.out.printf("Длина первого диапазона: %.2f", range1.getLength());
        System.out.println();

        System.out.print("Введите любое число: ");
        double number = scanner.nextDouble();
        System.out.println(range1.isNumberInside(number) ? "Число входит в первый  диапазон" :
                "Число не входит в первый диапазон");
        System.out.println();

        System.out.println("Второй диапазон");
        System.out.print("Введите начальную координату: ");
        double from = scanner.nextDouble();
        System.out.print("Введите конечную координату: ");
        double to = scanner.nextDouble();
        Range range2 = new Range(from, to);
        System.out.println();

        System.out.printf("Длина второго диапазона: %.2f", range2.getLength());
        System.out.println();

        System.out.print("Введите любое число: ");
        number = scanner.nextDouble();
        System.out.println(range2.isNumberInside(number) ? "Число входит во второй диапазон" :
                "Число не входит во второй диапазон");
        System.out.println();

        Range range3 = range1.getCrossingRange(range2);
        System.out.println("Интервал-пересечение");
        if (range3 == null) {
            System.out.println("Интервалы не пересекаются");
            System.out.println();
            System.out.println("Cумма интервалов");
            if (range1.isEdgeEqual(range2)) {
                Range range4 = range1.getCombinedRanges(range2);
                System.out.printf("Интервал: From %.2f To %.2f", range4.getFrom(), range4.getTo());
                System.out.println();
                System.out.println();
            } else {
                System.out.printf("Первый интервал: From %.2f To %.2f%n",
                        range1.getFrom(), range1.getTo());
                System.out.printf("Второй интервал: From %.2f To %.2f", range2.getFrom(), range2.getTo());
                System.out.println();
                System.out.println();
            }
            System.out.println("Разность интервалов равна нулю");
        } else {
            System.out.printf("From: %.2f%nTo: %.2f", range3.getFrom(), range3.getTo());
            System.out.println();
            System.out.println();

            range3 = range1.getCombinedRanges(range2);
            System.out.println("Сумма интервалов");
            System.out.printf("Интервал: From %.2f To %.2f", range3.getFrom(), range3.getTo());
            System.out.println();

            if (range1.isRangeInside(range2)) {
                System.out.println("Разность интервалов");
                System.out.printf("Первый интервал: From %.2f To %.2f%n", range1.getFrom(), range2.getFrom());
                System.out.printf("Второй интервал: From %.2f To %.2f", range2.getTo(), range1.getTo());
            } else if (range2.isRangeInside(range1)) {
                System.out.println("Разность интервалов равна нулю");
            } else {
                range3 = range1.getDifferenceOfRanges(range2);
                System.out.println();
                System.out.println("Разность интервалов");
                if (range3 == null) {
                    System.out.println("Разность интервалов равна нулю");
                } else {
                    System.out.printf("Интервал: From %.2f To %.2f", range3.getFrom(), range3.getTo());
                }
            }
        }
    }
}
