package task1_3;

import java.util.Scanner;

public class GeometricProgression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите начальное число A: ");
            double a = scanner.nextDouble();

            System.out.print("Введите множитель R: ");
            double r = scanner.nextDouble();

            System.out.print("Введите количество элементов N: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Количество элементов должно быть положительным");
            }

            System.out.println("Геометрическая прогрессия:");
            for (int i = 0; i < n; i++) {
                double term = a * Math.pow(r, i);
                System.out.printf("a%d = %.2f\n", i + 1, term);
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}