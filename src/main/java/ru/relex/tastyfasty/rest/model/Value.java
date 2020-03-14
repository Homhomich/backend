package ru.relex.tastyfasty.rest.model;

public class Value<T> {

    final T value;

    public Value(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
