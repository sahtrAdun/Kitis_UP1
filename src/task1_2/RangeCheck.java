package task1_2;

import java.util.Scanner;

public class RangeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        boolean isValid = (number > 10 && number < 50) || number == 0;

        if (isValid) {
            System.out.println("Число находится в допустимом диапазоне");
        } else {
            System.out.println("Число НЕ находится в допустимом диапазоне");
        }

        scanner.close();
    }
}
