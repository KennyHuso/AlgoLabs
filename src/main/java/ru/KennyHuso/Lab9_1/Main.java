package ru.KennyHuso.Lab9_1;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree tree = new BinarySearchTree();
        StringBuilder result = new StringBuilder();
        String line;

        // Читаем команды до конца ввода
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split("\\s+");

            String command = parts[0];
            int x = Integer.parseInt(parts[1]);

            switch (command) {
                case "insert":
                    tree.insert(x);
                    break;

                case "delete":
                    tree.delete(x);
                    break;

                case "has":
                    result.append(tree.has(x) ? "t" : "f")
                            .append("\n");
                    break;

                case "next":
                    Integer next = tree.next(x);
                    result.append(next == null ? "none" : next)
                            .append("\n");
                    break;

                case "prev":
                    Integer prev = tree.prev(x);
                    result.append(prev == null ? "none" : prev)
                            .append("\n");
                    break;
            }
        }
        // Выводим результаты команд
        System.out.print(result);
    }
}