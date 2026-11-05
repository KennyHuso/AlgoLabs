package ru.KennyHuso.Lab8_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        // Выделяем ровно 2 * n памяти. Листья будут лежать в индексах от n до 2n - 1
        int[] tree = new int[2 * n];

        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            tree[n + i] = Integer.parseInt(elements[i]); // Заполняем листья дерева
        }

        // Строим дерево отрезков снизу вверх
        for (int i = n - 1; i > 0; --i) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        int k = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < k; q++) {
            String[] query = br.readLine().trim().split(" ");
            int l = Integer.parseInt(query[0]) + n; // Сдвигаем левую границу в массив листьев
            int r = Integer.parseInt(query[1]) + n; // Сдвигаем правую границу в массив листьев

            int min = Integer.MAX_VALUE;

            while (l <= r) {
                if ((l % 2) == 1)  min = Math.min(min, tree[l++]); // Если левый индекс нечетный — берем его и сдвигаем право
                if ((r % 2) == 0) min = Math.min(min, tree[r--]); // Если правый индекс четный — берем его и сдвигаем лево
                l /= 2; // Переходим к родителям
                r /= 2;
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }
}
