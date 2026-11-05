package ru.KennyHuso.Lab4_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MinStackImpl stack = new MinStackImpl();
        String line;

        // Построчно читаем команды из консоли
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty()) {
                break; // Пустая строка завершает программу
            }

            if (line.startsWith("push")) {
                int value = Integer.parseInt(line.split("\\s+")[1]);
                stack.push(value);

            } else if (line.equals("pop")) {
                stack.pop();

            } else if (line.equals("top")) {
                System.out.println(stack.top());

            } else if (line.equals("min")) {
                System.out.println(stack.min());
            }
        }
    }
}