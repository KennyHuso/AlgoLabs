package ru.KennyHuso.Lab6_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().trim().split(" ");

        long n = Long.parseLong(parts[0]);
        long w = Long.parseLong(parts[1]);
        long h = Long.parseLong(parts[2]);

        // Левая граница — 0, правая — дипломы выстроены в одну линию по максимальной стороне
        long left = 0;
        long right = Math.max(w, h) * n;
        long ans = right;

        // Бинарный поиск по ответу
        while (left <= right) {
            long mid = left + (right - left) / 2;

            // Защита от переполнения: проверяем, хватает ли стороны коробки
            if ((mid / w) >= n || (mid / h) >= n || (mid / w) * (mid / h) >= n) {
                ans = mid;        // Запоминаем возможный размер коробки
                right = mid - 1;  // Пробуем найти сторону ещё меньше
            } else {
                left = mid + 1;   // Коробка слишком мала, увеличиваем размер
            }
        }

        System.out.print(ans);
    }
}
