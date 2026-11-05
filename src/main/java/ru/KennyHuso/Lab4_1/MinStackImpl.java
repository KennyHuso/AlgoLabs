package ru.KennyHuso.Lab4_1;

public class MinStackImpl implements MinStack<Integer> {

    private int value;         // Значение текущего элемента
    private int currentMin;    // Минимум на текущем уровне стека
    private MinStackImpl next; // Ссылка на следующий элемент

    private MinStackImpl head = null; // Вершина стека

    // Создаем новый узел и связываем его с предыдущим
    private MinStackImpl(int value, int currentMin, MinStackImpl next) {
        this.value = value;
        this.currentMin = currentMin;
        this.next = next;
    }

    public MinStackImpl() {}

    @Override
    public void push(Integer value) {
        // Вычисляем новый минимум
        int min = (head == null) ? value : Math.min(value, head.currentMin);

        // Добавляем новый элемент на вершину стека
        head = new MinStackImpl(value, min, head);
    }

    @Override
    public Integer pop() {
        if (head == null) return null;

        int val = head.value;

        // Перемещаем вершину на следующий элемент
        head = head.next;
        return val;
    }

    @Override
    public Integer top() {
        // Возвращаем верхний элемент, не удаляя его
        return (head == null) ? null : head.value;
    }

    @Override
    public Integer min() {
        // Возвращаем уже сохраненный минимум
        return (head == null) ? null : head.currentMin;
    }
}
