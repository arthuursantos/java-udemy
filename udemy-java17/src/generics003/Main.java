package generics003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3, 4.4);
        List<Object> objs = new ArrayList<>();

        copy(ints, objs);
        printList(objs);
        copy(doubles, objs);
        printList(objs);

    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.print(object+" ");
        }
        System.out.println();
    }

}
