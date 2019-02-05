package com.company.homework4;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double COEFFICIENT = 1.5;
    private Object[] data;
    private int size = 0;

    public ArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    @Override
    public void add(T t) {
        if (size == data.length) {
            resize((int) (data.length * COEFFICIENT) + 1);
        } else {
            data[size++] = t;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return (T) data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void remove(int index) {
        if (index < size) {
            int numMoved = size - index - 1;
            System.arraycopy(data, index + 1, data, index, numMoved);

            data[--size] = null;

            if (data.length > DEFAULT_CAPACITY && size < data.length / COEFFICIENT)
                resize((int) ((data.length - 1) / COEFFICIENT));
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public String toString() {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (T) data[i];
        }
        return Arrays.toString(temp);
    }
}
