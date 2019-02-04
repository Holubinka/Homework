package com.company.homework4;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private final int INIT_CAPACITY;
    private final int DEFAULT_CAPACITY = 10;
    private final double COEFFICIENT = 1.5;
    private T[] array;
    private int size = 0;

    public ArrayList() {
        this.INIT_CAPACITY = 10;
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int INIT_CAPACITY) {
        this.INIT_CAPACITY = INIT_CAPACITY;
        array = (T[]) new Object[INIT_CAPACITY];
    }

    @Override
    public void add(T t) {
        if (size == array.length) {
            resize((int) (array.length * COEFFICIENT) + 1);
        } else {
            array[size++] = t;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Некоректний індекс");
        }
    }

    @Override
    public void remove(int index) {
        if (index < size) {
            int numMoved = size - index - 1;
            System.arraycopy(array, index + 1, array, index, numMoved);

            array[--size] = null;

            if (array.length > DEFAULT_CAPACITY && size < array.length / COEFFICIENT)
                resize((int) ((array.length - 1) / COEFFICIENT));
        } else {
            throw new ArrayIndexOutOfBoundsException("Некоректний індекс");
        }
    }

    private T[] resize(int newCapacity) {
        T[] temp = Arrays.copyOf(array, newCapacity);
        return temp;
    }

    @Override
    public String toString() {
        T[] temp = (T[])new Object[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }
        return Arrays.toString(temp);
    }
}
