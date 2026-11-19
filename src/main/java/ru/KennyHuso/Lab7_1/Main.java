package ru.KennyHuso.Lab7_1;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Path inputPath = Paths.get("roguelike-input.csv");
        Path outputPath = Paths.get("roguelike-output.txt");

        // Считываем игровое поле из файла
        List<int[]> rows = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] values = line.split(";");
                int[] row = new int[values.length];

                for (int j = 0; j < values.length; j++) {
                    row[j] = Integer.parseInt(values[j].trim());
                }

                rows.add(row);
            }
        }

        // Создание игрового поля
        int n = rows.size();
        int m = rows.get(0).length;

        int[][] field = new int[n][m];

        for (int i = 0; i < n; i++) {
            field[i] = rows.get(i);
        }

        // Создаём таблицу динамического программирования
        int[][] dp = new int[n][m];

        dp[0][0] = field[0][0];

        // Заполняем первую строку
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + field[0][j];
        }

        // Заполняем первый столбец
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + field[i][0];
        }

        // Находим максимальное количество монет для каждой клетки
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
                        + field[i][j];
            }
        }

        // Восстанавливаем оптимальный путь
        StringBuilder path = new StringBuilder();

        int i = n - 1;
        int j = m - 1;

        while (i > 0 || j > 0) {

            if (i == 0) {
                path.append("R");
                j--;
            } else if (j == 0) {
                path.append("D");
                i--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                path.append("D");
                i--;
            } else {
                path.append("R");
                j--;
            }
        }

        // Переворачиваем путь, так как восстанавливали его с конца
        path.reverse();

        // Записываем результат в выходной файл
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write(String.valueOf(dp[n - 1][m - 1]));
            writer.newLine();
            writer.write(path.toString());
        }
    }
}
