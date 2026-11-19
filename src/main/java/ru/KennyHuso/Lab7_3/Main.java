package ru.KennyHuso.Lab7_3;
import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Path inputPath = Paths.get("lcs-input.txt");

        // Считываем две последовательности из файла
        String x;
        String y;

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            x = reader.readLine().trim();
            y = reader.readLine().trim();
        }

        int n = x.length();
        int m = y.length();

        // Создаём таблицу динамического программирования
        int[][] dp = new int[n + 1][m + 1];

        // Находим длину наибольшей общей подпоследовательности
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }
        // Выводим длину наибольшей общей подпоследовательности
        System.out.println(dp[n][m]);
    }
}
