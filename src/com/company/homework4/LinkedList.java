package com.company.homework4;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public void add(T t) {
        Node<T> lastNode = last;
        Node<T> newNode = new Node<>(lastNode, t, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNode(index);
        return node != null ? node.element : null;
    }

    private Node<T> getNode(int index) {
        if (index >= 0 && index <= size) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            throw new ArrayIndexOutOfBoundsException("Неправильний індекс");
        }
    }

    @Override
    public void remove(int index) {
        Node<T> node = getNode(index);
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) {
            first = node.next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = node.prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.element = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> node = first;
        for (int i = 0; i < size - 1; i++) {
            result.append(node).append(", ");
            node = node.next;
        }
        result.append(node.element).append("]");
        return result.toString();
    }

    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "" + element;
        }
    }
}
