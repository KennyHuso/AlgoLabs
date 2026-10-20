package ru.KennyHuso.Lab2_3;
import ru.KennyHuso.Lab2_1.Sorting;
import java.util.*;

public class StudentSort implements Sorting<Student> {

    // Внутренний метод разделения
    private void slice(List<Student> students, int start, int end, boolean byName) {
        if (start >= end) {
            return;
        }
        int ser = start + (end - start) / 2;

        slice(students, start, ser, byName);
        slice(students, ser + 1, end, byName);

        merge(students, start, ser, end, byName);
    }

    // Внутренний метод слияния
    private void merge(List<Student> students, int start, int ser, int end, boolean byName) {
        List<Student> left = new ArrayList<>(students.subList(start, ser + 1));
        List<Student> right = new ArrayList<>(students.subList(ser + 1, end + 1));

        int i = 0, j = 0, k = start;

        while (i < left.size() && j < right.size()) {
            boolean OnTheLeft;

            if (byName) {
                // Сравниваем имена по буквам
                OnTheLeft = left.get(i).getName().compareTo(right.get(j).getName()) <= 0;
            } else {
                // Сравниваем возраст по возрастанию
                OnTheLeft = left.get(i).getAge() <= right.get(j).getAge();
            }

            if (OnTheLeft) {
                students.set(k, left.get(i));
                i++;
            } else {
                students.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            students.set(k, left.get(i));
            i++; k++;
        }
        while (j < right.size()) {
            students.set(k, right.get(j));
            j++; k++;
        }
    }

    @Override
    public void sort(List<Student> students) {
        if (students == null || students.size() <= 1) {
            return;
        }
        // Сортируем по возрасту (byName = false)
        slice(students, 0, students.size() - 1, false);

        // Сортируем по имени (byName = true)
        // Благодаря стабильности MergeSort, внутри одинаковых имен сохранится порядок по возрасту!
        slice(students, 0, students.size() - 1, true);
    }
}
