package ru.KennyHuso.Lab6_3;
import java.io.*;

public class Main {
    // Вычисляет значение левой части уравнения
    public static double function(double x) {
        return x * x - x + Math.sqrt(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Считываем значение a
        double a = Double.parseDouble(br.readLine().trim());

        // Левая и правая границы поиска
        double left = 0;
        double right = a;

        // Требуемая точность
        double epsilon = 0.0000001;

        // Пока границы недостаточно близки, продолжаем поиск
        while (right - left > epsilon) {
            // Находим середину текущего отрезка
            double mid = (left + right) / 2;

            // Если значение функции меньше a, значит нужно искать большее значение x
            if (function(mid) < a) {
                left = mid;
            } else {
                // Иначе ответ находится левее
                right = mid;
            }
        }

        // Середина оставшегося маленького отрезка — искомое x
        double x = (left + right) / 2;

        // Выводим результат с достаточной точностью
        System.out.printf("%.6f%n", x);
    }
}
