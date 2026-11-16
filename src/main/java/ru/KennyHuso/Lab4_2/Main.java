package ru.KennyHuso.Lab4_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueueImpl queue = new PriorityQueueImpl();
        StringBuilder result = new StringBuilder();
        String line;

        // Построчно читаем команды из консоли
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            // Пустая строка завершает программу
            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("enqueue")) {
                int value = Integer.parseInt(parts[1]);
                queue.enqueue(value);

            } else if (parts[0].equals("dequeue-max")) {
                Integer value = queue.dequeueMax();

                // Если очередь пуста
                if (value == null) {
                    result.append("*\n");
                } else {
                    // Выводим номер операции и значение
                    result.append(queue.getLastOperation())
                            .append(" ")
                            .append(value)
                            .append("\n");
                }

            } else if (parts[0].equals("inc")) {
                long operation = Long.parseLong(parts[1]);
                int addition = Integer.parseInt(parts[2]);

                queue.increment(operation, addition);
            }
        }
        System.out.print(result);
    }
}