package ru.KennyHuso.Lab3_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Считываем количество чисел N
        int N = Integer.parseInt(reader.readLine().trim());
        List<BigInteger> nums = new ArrayList<>(N);

        // Читаем N строк, в каждой из которых записано одно 20-значное число
        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            nums.add(new BigInteger(line.trim()));
        }

        // Запускаем поразрядную цифровую сортировку
        RadixSort sorter = new RadixSort();
        sorter.sort(nums);

        // Выводим результат: каждое число на новой строке, как в примере
        StringBuilder sb = new StringBuilder();
        for (BigInteger num : nums) {
            sb.append(num).append("\n");
        }
        System.out.print(sb.toString());
    }
}
