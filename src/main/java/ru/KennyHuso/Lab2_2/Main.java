package ru.KennyHuso.Lab2_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Используем BufferedReader вместо Scanner, чтобы программа не зависала на 100 000 чисел
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Считываем первую строку с числом N
        int N = Integer.parseInt(reader.readLine().trim());
        List<Integer> nums = new ArrayList<>(N);

        // Считываем вторую строку со всеми числами и разбиваем её по пробелам
        String[] elements = reader.readLine().split(" ");

        // Считываем N чисел и добавляем их в лист
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(elements[i]));
        }

        MergeSort listSorter = new MergeSort();
        listSorter.sort(nums);

        // Быстро склеиваем результат в одну строку, чтобы не тормозить вывод в консоль
        StringBuilder sb = new StringBuilder();
        for (int number : nums) {
            sb.append(number).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
