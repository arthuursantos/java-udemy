package generics002;

import java.util.Arrays;
import java.util.List;

public class generics002<T> {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 213, 12);
        List<String> strs = Arrays.asList("Vai", "Corinthians", "Garro");
        wildcard.print(nums);
        wildcard.print(strs);
    }

    static class wildcard {
        public static void print(List<?> list) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

}