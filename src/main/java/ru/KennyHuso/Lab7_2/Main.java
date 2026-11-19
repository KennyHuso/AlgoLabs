package ru.KennyHuso.Lab7_2;
import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Path inputPath = Paths.get("lis-input.txt");
        Path outputPath = Paths.get("lis-output.txt");

        // Считываем входные данные
        int n;
        int[] a;

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            n = Integer.parseInt(reader.readLine().trim());

            String[] values = reader.readLine().trim().split("\\s+");
            a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(values[i]);
            }
        }

        int[] dp = new int[n]; // Длина НВП, которая заканчивается на элементе с индексом i
        int[] prev = new int[n]; // индекс предыдущего элемента этой подпоследовательности

        // Ищем наибольшую возрастающую подпоследовательность
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        // Находим максимальную длину и последний индекс
        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Восстанавливаем последовательность
        int[] result = new int[maxLength];
        int index = maxLength - 1;

        while (lastIndex != -1) {
            result[index] = a[lastIndex];
            index--;
            lastIndex = prev[lastIndex];
        }

        // Формируем и записываем результат
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write(String.valueOf(maxLength));
            writer.newLine();

            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < maxLength; i++) {
                answer.append(result[i]);

                if (i < maxLength - 1) {
                    answer.append(" ");
                }
            }
            writer.write(answer.toString());
        }
    }
}