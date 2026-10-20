package ru.KennyHuso.Lab3_1;
import ru.KennyHuso.Lab2_1.Sorting;
import java.util.*;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        // Заводим массив для подсчета частоты встреченных чисел
        int[] count = new int[128];
        // Считаем, сколько раз встречается каждое число
        for (int num : nums) {
            count[num]++;
        }
        // Перезаписываем оригинальный лист по возрастанию
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            // Пока счетчик для текущего числа больше нуля, пишем его в лист
            while (count[i] > 0) {
                nums.set(index, i);
                index++;
                count[i]--;
            }
        }
    }
}
