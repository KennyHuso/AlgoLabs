package ru.KennyHuso.Lab2_2;
import ru.KennyHuso.Lab2_1.Sorting;
import java.util.*;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;

        // Дробим левую и правую половины
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        // Упорядоченно соединяем обратно
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> left = new ArrayList<>(nums.subList(start, middle + 1));
        List<Integer> right = new ArrayList<>(nums.subList(middle + 1, end + 1));

        int i = 0;
        int j = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                nums.set(k, left.get(i));
                i++;
            } else {
                nums.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            nums.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            nums.set(k, right.get(j));
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        slice(nums, 0, nums.size() - 1);
    }
}
