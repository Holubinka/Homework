package com.company.homework4;

public class LinkedList<T> implements List<T> {
    private Entry<T> first;
    private Entry<T> last;
    private int size = 0;

    @Override
    public void add(T t) {
        Entry<T> lastNode = last;
        Entry<T> newNode = new Entry<>(lastNode, t, null);
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
        Entry<T> node = getNode(index);
        return node != null ? node.element : null;
    }

    private Entry<T> getNode(int index) {
        if (index >= 0 && index <= size) {
            Entry<T> node = first;
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
        Entry<T> node = getNode(index);
        Entry<T> prev = node.prev;
        Entry<T> next = node.next;

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
        StringBuilder result=new StringBuilder("[");
        Entry<T> node = first;
        for (int i = 0; i < size-1; i++) {
            result.append(node).append(", ");
            node = node.next;
        }
        result.append(node.element).append("]");
        return result.toString();
    }

    private static class Entry<T> {
        private T element;
        private Entry<T> next;
        private Entry<T> prev;

        Entry(Entry<T> prev, T element, Entry<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return  ""+element;
        }
    }
}
