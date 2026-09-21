package ru.KennyHuso.Lab1_2;
import java.util.Arrays;

public class Solution {
    public int removeElementInplace(int[] arr, int val) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }
}
