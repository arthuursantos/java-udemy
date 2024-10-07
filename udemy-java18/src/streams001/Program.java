package streams001;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(3, 4, 5, 6, 10, 7);
        Stream<Integer> stream1 = nums.stream();
        System.out.println(Arrays.toString(stream1.toArray()));

        Stream<String> stream2 = Stream.of("Arthur", "Lucas", "Pedro");
        System.out.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, i -> i + 2);
        System.out.println(Arrays.toString(stream3.limit(10).toArray()));

        Stream<Long> fibonacci = Stream.iterate(new Long[]{ 0L, 1L }, p -> new Long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(fibonacci.limit(10).toArray()));

    }
}
