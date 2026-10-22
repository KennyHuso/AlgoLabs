package ru.KennyHuso.Lab3_2;
import ru.KennyHuso.Lab2_1.Sorting;
import java.math.BigInteger;
import java.util.*;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        int numDigits = 20;

        // Запускаем цикл 20 раз — от самого младшего (последнего) разряда к старшему
        for (int digitIdx = numDigits - 1; digitIdx >= 0; digitIdx--) {

            // Создаем 10 корзин для цифр от 0 до 9
            List<List<BigInteger>> buckets = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            // Распределяем числа по корзинам в зависимости от цифры на текущем разряде
            for (BigInteger num : nums) {
                String strNum = num.toString();

                // Извлекаем символ цифры и превращаем в int
                int digit = strNum.charAt(digitIdx) - '0';
                buckets.get(digit).add(num);
            }

            // Собираем числа из корзин обратно в оригинальный список nums
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (BigInteger num : buckets.get(i)) {
                    nums.set(index, num);
                    index++;
                }
            }
        }
    }
}
