package com.holubinka.homework4;

public interface List<T> {
    T get(int index);

    void add(T t);

    void remove(int index);

    int size();
}
