package ru.KennyHuso.Lab4_2;
import java.util.*;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    // Один элемент очереди: значение и номер операции добавления
    private static class Node {
        int value;
        long operation;

        Node(int value, long operation) {
            this.value = value;
            this.operation = operation;
        }
    }

    // Куча для хранения элементов
    private final ArrayList<Node> heap = new ArrayList<>();

    // Хранит: номер операции -> текущий индекс элемента в куче
    private final HashMap<Long, Integer> positions = new HashMap<>();

    private long operationCounter = 0;
    private long lastOperation = -1;

    // Возвращает номер родителя
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Возвращает индекс левого потомка
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // Возвращает индекс правого потомка
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // Меняет два элемента местами
    private void swap(int first, int second) {
        Node temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);

        // Обновляем позиции элементов после перестановки
        positions.put(heap.get(first).operation, first);
        positions.put(heap.get(second).operation, second);
    }

    // Поднимает элемент вверх, пока куча не станет правильной
    private void siftUp(int index) {
        while (index > 0 && heap.get(parent(index)).value < heap.get(index).value) {
            int parentIndex = parent(index);

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // Опускает элемент вниз, пока куча не станет правильной
    private void siftDown(int index) {
        while (true) {
            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);

            // Ищем наибольший из элемента и его потомков
            if (left < heap.size()
                    && heap.get(left).value > heap.get(largest).value) {
                largest = left;
            }
            if (right < heap.size()
                    && heap.get(right).value > heap.get(largest).value) {
                largest = right;
            }
            // Если элемент уже больше потомков, заканчиваем
            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    @Override
    public void enqueue(Integer value) {
        operationCounter++;

        // Добавляем новый элемент в конец кучи
        Node node = new Node(value, operationCounter);
        heap.add(node);

        int index = heap.size() - 1;

        // Запоминаем, где находится этот элемент
        positions.put(operationCounter, index);

        // Поднимаем элемент на нужное место
        siftUp(index);
    }

    @Override
    public Integer dequeueMax() {

        // Если очередь пустая
        if (heap.isEmpty()) {
            lastOperation = -1;
            return null;
        }

        // Максимальный элемент всегда находится в начале кучи
        Node max = heap.get(0);
        lastOperation = max.operation;

        // Удаляем информацию о позиции элемента
        positions.remove(max.operation);

        // Если элемент был один
        if (heap.size() == 1) {
            heap.remove(0);
            return max.value;
        }

        // Переносим последний элемент на место максимального
        Node last = heap.remove(heap.size() - 1);
        heap.set(0, last);
        positions.put(last.operation, 0);

        // Восстанавливаем структуру кучи
        siftDown(0);

        return max.value;
    }

    @Override
    public void increment(long operation, Integer addition) {

        // Находим индекс элемента по номеру операции
        Integer index = positions.get(operation);

        // Если элемент уже был удален, ничего не делаем
        if (index == null) {
            return;
        }

        // Увеличиваем значение
        heap.get(index).value += addition;

        // Проверяем, нужно ли поднять или опустить элемент
        if (index > 0 && heap.get(parent(index)).value < heap.get(index).value) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    // Возвращает номер операции последнего извлеченного элемента
    public long getLastOperation() {
        return lastOperation;
    }
}