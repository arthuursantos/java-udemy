package generics001.services;

import java.util.ArrayList;
import java.util.List;

public class Services<T> {

    protected List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public static <T extends Comparable> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Lista vazia");
        }
        T max = list.getFirst();
        for (T produto : list) {
            if (produto.compareTo(max) > 0) {
                max = produto;
            }
        }
        return max;
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Lista vazia!");
        }
        return list.getFirst();
    }

    public void print() {
        for (T value : list) {
            System.out.print(value + " ");
        }
    }

}
