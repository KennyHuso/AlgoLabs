package ru.KennyHuso.Lab5;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMapImpl<String> map = new HashMapImpl<>();
        StringBuilder result = new StringBuilder();
        String line;

        // Читаем команды до пустой строки или конца ввода
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");

            if (parts[0].equals("put")) {
                map.put(parts[1], parts[2]);

            } else if (parts[0].equals("get")) {
                result.append(map.getValue(parts[1])).append("\n");

            } else if (parts[0].equals("delete")) {
                map.delete(parts[1]);
            }
        }
        // Выводим результаты команд get
        System.out.print(result);
    }
}