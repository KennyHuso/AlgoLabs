package ru.KennyHuso.Lab3_3;
import ru.KennyHuso.Lab2_3.Student;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем один экземпляр нашей обобщенной сортировки raw-типом или через дженерик
        GenericMergeSort listSorter = new GenericMergeSort();

        System.out.println("=== ТЕСТИРОВАНИЕ ОБОБЩЕННОЙ СОРТИРОВКИ ===\n");

        // 1. Тестируем тип Integer
        List<Integer> integers = new ArrayList<>(Arrays.asList(5, 1, 9, 3, 7));
        System.out.println("Исходные Integer: " + integers);
        listSorter.sort(integers);
        System.out.println("Отсортированные:  " + integers + "\n");

        // 2. Тестируем тип String (Алфавитный порядок)
        List<String> strings = new ArrayList<>(Arrays.asList("Яна", "Антон", "Денис", "Борис"));
        System.out.println("Исходные String: " + strings);
        listSorter.sort(strings);
        System.out.println("Отсортированные: " + strings + "\n");

        // 3. Тестируем тип LocalDateTime (Хронологический порядок)
        List<LocalDateTime> dates = new ArrayList<>(Arrays.asList(
                LocalDateTime.of(2026, 10, 21, 12, 0),
                LocalDateTime.of(2023, 5, 10, 9, 30),
                LocalDateTime.of(2025, 1, 1, 0, 0)
        ));
        System.out.println("Исходные LocalDateTime: " + dates);
        listSorter.sort(dates);
        System.out.println("Отсортированные:        " + dates + "\n");

        // 4. Тестируем тип Student (из задачи 2.3)
        // Чтобы он сортировался, в его классе compareTo должен возвращать name.compareTo(o.getName())
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Вася", 19),
                new Student("Антон", 22),
                new Student("Борис", 20)
        ));
        System.out.print("Исходные Student: ");
        printStudents(students);
        listSorter.sort(students);
        System.out.print("Отсортированные:  ");
        printStudents(students);
        System.out.println();

        // 5. Тестируем тип UUID (Лексикографический порядок идентификаторов)
        List<UUID> uuids = new ArrayList<>(Arrays.asList(
                UUID.fromString("c9a646d3-9c61-4cd8-893c-74cf617a224a"),
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                UUID.fromString("a1a1a1a1-a1a1-a1a1-a1a1-a1a1a1a1a1a1")
        ));
        System.out.println("Исходные UUID: " + uuids);
        listSorter.sort(uuids);
        System.out.println("Отсортированные: " + uuids + "\n");
    }

    // Вспомогательный метод для красивого вывода студентов на экран
    private static void printStudents(List<Student> students) {
        StringBuilder sb = new StringBuilder("[");
        for (Student s : students) {
            sb.append(s.getName()).append("(").append(s.getAge()).append("), ");
        }
        if (!students.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
