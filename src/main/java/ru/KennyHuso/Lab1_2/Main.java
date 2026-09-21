package ru.KennyHuso.Lab1_2;
import java.util.Arrays;

public class Main {
    public static int removeElementInplace(int[] arr, int val) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] test1 = {4, 5, 5, 4};
        int len1 = removeElementInplace(test1, 4);
        System.out.println("Тест 1 (val=4): Новая длина = " + len1 + ", Массив = " + Arrays.toString(Arrays.copyOf(test1, len1)));

        int[] test2 = {0, 2, 6, 6, 1, 0, 4, 6};
        int len2 = removeElementInplace(test2, 6);
        System.out.println("Тест 2 (val=6): Новая длина = " + len2 + ", Массив = " + Arrays.toString(Arrays.copyOf(test2, len2)));
    }
}
