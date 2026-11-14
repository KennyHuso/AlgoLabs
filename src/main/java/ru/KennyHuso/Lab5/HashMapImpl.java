package ru.KennyHuso.Lab5;
import java.util.*;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    // Таблица, в каждой ячейке находится список пар ключ-значение
    private final ArrayList<LinkedList<Entry<V>>> table;

    // Класс для хранения одной пары: ключ + значение
    private static class Entry<V> {
        String key;
        V value;

        Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Создаем таблицу и добавляем пустые списки
    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);

        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }

    private long hashByString(String value) {
        long hash = 0;

        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        // Находим индекс ячейки в таблице
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> list = table.get(index);

        // Проверяем, есть ли уже такой ключ
        for (Entry<V> entry : list) {
            if (entry.key.equals(key)) {
                // Если ключ уже существует, меняем значение
                entry.value = value;
                return;
            }
        }
        // Если ключа нет, добавляем новую пару
        list.add(new Entry<>(key, value));
    }

    @Override
    public V getValue(String key) {
        // Находим нужную цепочку
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> list = table.get(index);

        // Ищем ключ в списке
        for (Entry<V> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        // Если ключ не найден
        return null;
    }

    @Override
    public V delete(String key) {
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> list = table.get(index);

        // Ищем нужную пару
        for (Entry<V> entry : list) {
            if (entry.key.equals(key)) {
                V value = entry.value;

                // Удаляем найденную пару
                list.remove(entry);
                return value;
            }
        }
        // Если ключ не найден
        return null;
    }
}