package ru.KennyHuso.Lab2_1;
import java.util.*;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        // Начинаем со второго числа, тк первое уже отсортировано
        for (int i = 1; i < nums.size(); i++) {
            // Сравниваем текущее с предыдущим
            int j = i;

            // Двигаем число влево, пока оно меньше
            while (j > 0 && nums.get(j) < nums.get(j - 1)) {
                // Временно сохраняем текущее число
                int numthis = nums.get(j);
                // Передвигаем большее число вправо
                nums.set(j, nums.get(j - 1));
                nums.set(j - 1, numthis);
                j--;
            }
        }
    }
}