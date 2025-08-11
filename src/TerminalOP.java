import java.util.*;
import java.util.stream.Collectors;

public class TerminalOP {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6);
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "date");

        // 1. forEach: Performs an action for each element
        System.out.print("1. forEach (print numbers): ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. forEachOrdered: Performs an action in encounter order (useful for parallel streams)
        System.out.print("2. forEachOrdered (ordered print): ");
        numbers.stream().parallel().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();

        // 3. toArray: Returns an array of stream elements
        Object[] numberArray = numbers.stream().toArray();
        System.out.println("3. toArray: " + Arrays.toString(numberArray));

        // 4. toArray(IntFunction): Returns a typed array
        Integer[] integerArray = numbers.stream().toArray(Integer[]::new);
        System.out.println("4. toArray(Integer[]::new): " + Arrays.toString(integerArray));

        // 5. reduce (BinaryOperator): Reduces stream to a single value
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        System.out.println("5. reduce (sum): " + sum.orElse(0));

        // 6. reduce (identity, BinaryOperator): Reduces with an identity value
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("6. reduce (product with identity): " + product);

        // 7. reduce (identity, accumulator, combiner): Reduces with parallel support
        int sumParallel = numbers.stream().parallel()
                .reduce(0, Integer::sum, Integer::sum);
        System.out.println("7. reduce (parallel sum): " + sumParallel);

        // 8. collect (Collector): Collects elements into a collection
        List<Integer> collectedList = numbers.stream()
                .collect(Collectors.toList());
        System.out.println("8. collect (toList): " + collectedList);

        // 9. collect (supplier, accumulator, combiner): Custom collector
        List<String> customCollect = words.stream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("9. collect (custom to list): " + customCollect);

        // 10. min: Finds the minimum element
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println("10. min: " + min.orElse(null));

        // 11. max: Finds the maximum element
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println("11. max: " + max.orElse(null));

        // 12. count: Counts elements in the stream
        long count = numbers.stream().count();
        System.out.println("12. count: " + count);

        // 13. anyMatch: Checks if any element matches a predicate
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("13. anyMatch (has even): " + hasEven);

        // 14. allMatch: Checks if all elements match a predicate
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("14. allMatch (all positive): " + allPositive);

        // 15. noneMatch: Checks if no elements match a predicate
        boolean noNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("15. noneMatch (no negative): " + noNegative);

        // 16. findFirst: Returns the first element
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("16. findFirst: " + first.orElse(null));

        // 17. findAny: Returns any element (useful in parallel streams)
        Optional<Integer> any = numbers.stream().parallel().findAny();
        System.out.println("17. findAny (parallel): " + any.orElse(null));
    }
}