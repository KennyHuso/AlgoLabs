package ru.KennyHuso.Lab3_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine().trim());
        List<Integer> nums = new ArrayList<>(N);

        String[] el = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(el[i]));
        }

        // Создаем объект сортировки подсчетом и запускаем её
        CountingSort listSorter = new CountingSort();
        listSorter.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int number : nums) {
            sb.append(number).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
