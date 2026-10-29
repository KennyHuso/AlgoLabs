package ru.KennyHuso.Lab6_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Читаем первый массив чисел
        int n = Integer.parseInt(reader.readLine().trim());
        int[] arr = new int[n];
        String[] firstLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(firstLine[i]);
        }

        // Читаем массив запросов
        int m = Integer.parseInt(reader.readLine().trim());
        String[] secondLine = reader.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        // Обрабатываем каждый запрос бинарным поиском
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(secondLine[i]);
            sb.append(findClosest(arr, query)).append(" ");
        }

        System.out.print(sb.toString().trim());
    }

    // Метод приближенного бинарного поиска
    private static int findClosest(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Если число меньше самого первого или больше самого последнего
        if (target <= arr[left]) return arr[left];
        if (target >= arr[right]) return arr[right];

        // Стандартный бинарный поиск
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Нашли точное совпадение
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // После цикла left и right укажут на двух ближайших соседей
        // Сравниваем расстояния до них. Если расстояния равны, берем левое (меньшее)
        if (Math.abs(arr[left] - target) < Math.abs(arr[right] - target)) {
            return arr[left];
        } else {
            return arr[right];
        }
    }
}
