package ru.KennyHuso.Lab9_1;

public class BinarySearchTree {
    // Узел дерева
    private static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    // Добавление элемента
    public void insert(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;

        while (true) {
            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;

            } else if (key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;

            } else {
                return; // Одинаковые ключи не добавляем
            }
        }
    }

    // Проверка наличия элемента
    public boolean has(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.key) {
                return true;
            }

            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Поиск минимального элемента, который больше key
    public Integer next(int key) {
        Node current = root;
        Integer result = null;

        while (current != null) {
            if (current.key > key) {
                result = current.key;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return result;
    }

    // Поиск максимального элемента, который меньше key
    public Integer prev(int key) {
        Node current = root;
        Integer result = null;

        while (current != null) {
            if (current.key < key) {
                result = current.key;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return result;
    }

    // Удаление элемента
    public void delete(int key) {
        Node current = root;
        Node parent = null;

        // Ищем удаляемый узел
        while (current != null && current.key != key) {
            parent = current;

            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return; // Такого элемента нет
        }

        // Если у узла два потомка
        if (current.left != null && current.right != null) {
            Node successorParent = current;
            Node successor = current.right;

            // Находим минимальный элемент правого поддерева
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Переносим ключ найденного узла
            current.key = successor.key;

            // Удаляем узел-преемник
            if (successorParent == current) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }

            return;
        }

        // Если у узла ноль или один потомок
        Node child;

        if (current.left != null) {
            child = current.left;
        } else {
            child = current.right;
        }

        // Подключаем потомка вместо удаляемого узла
        if (parent == null) {
            root = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}