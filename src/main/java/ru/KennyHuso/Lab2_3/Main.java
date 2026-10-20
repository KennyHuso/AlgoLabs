package ru.KennyHuso.Lab2_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        // Читаем количество студентов N
        int N = Integer.parseInt(rd.readLine().trim());
        List<Student> students = new ArrayList<>(N);

        // Читаем N строк. Каждая строка содержит "Имя Возраст"
        for (int i = 0; i < N; i++) {
            String line = rd.readLine();
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.trim().split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            students.add(new Student(name, age));
        }

        // Запускаем нашу двойную сортировку структур
        StudentSort sorter = new StudentSort();
        sorter.sort(students);

        // Быстрый вывод результата в консоль
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName()).append(" ").append(student.getAge()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
