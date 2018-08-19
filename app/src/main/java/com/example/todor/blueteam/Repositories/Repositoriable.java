package com.example.todor.blueteam.Repositories;

import java.util.List;
import java.util.function.Consumer;

public interface Repositoriable<T> {
    void getAll(Consumer<List<T>> action );


    void add(T item);

}

