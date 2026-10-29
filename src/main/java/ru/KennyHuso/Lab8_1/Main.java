package ru.KennyHuso.Lab8_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Читаем размер массива
        int n = Integer.parseInt(reader.readLine().trim());

        // Создаем массив префиксных сумм размером n + 1
        long[] pref = new long[n + 1];
        String[] elements = reader.readLine().split(" ");

        // Заполняем префиксы: каждая ячейка — это сумма предыдущей и текущего числа
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + Integer.parseInt(elements[i]);
        }

        // Читаем количество запросов K
        int k = Integer.parseInt(reader.readLine().trim());
        StringBuilder sb = new StringBuilder();

        // Отвечаем на каждый запрос за O(1)
        for (int q = 0; q < k; q++) {
            String[] query = reader.readLine().split(" ");
            int i = Integer.parseInt(query[0]);
            int j = Integer.parseInt(query[1]);

            // Вычисляем сумму на отрезке по формуле префиксов
            long sum = pref[j + 1] - pref[i];
            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}
