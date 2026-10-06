package ru.KennyHuso.Lab2_1;
import java.util.*;

public class Main {
    static void main() {
        Scanner inputNumber = new Scanner(System.in);
        int N = inputNumber.nextInt();
        List<Integer> nums = new ArrayList<>();

        // Считываем N чисел и добавляем их в лист
        for (int i = 0; i < N; i++) {
            nums.add(inputNumber.nextInt());
        }

        // Создаём объект InsertionSort
        InsertionSort listSorter = new InsertionSort();
        // Сортируем лист используя InsertionSort
        listSorter.sort(nums);

        for (int number : nums) {
            System.out.print(number + " ");
            }
        }
    }
