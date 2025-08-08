import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream1 {
    public static void main(String[] args) {
        // Sample data: List of strings
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "date", "elderberry");
        // Sample data: List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 6);

        // 1. filter(Predicate<T> predicate): Keep elements matching the condition
        System.out.println("1. filter (words starting with 'a'):");
        words.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println); // Output: apple, apple

        // 2. map(Function<T, R> mapper): Transform each element
        System.out.println("\n2. map (to uppercase):");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: APPLE, BANANA, APPLE, CHERRY, DATE, ELDERBERRY

        // 3. flatMap(Function<T, Stream<R>> mapper): Flatten nested streams
        System.out.println("\n3. flatMap (flatten nested lists):");
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );
        nestedList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println); // Output: a, b, c, d

        // 4. distinct(): Remove duplicates
        System.out.println("\n4. distinct (remove duplicate words):");
        words.stream()
                .distinct()
                .forEach(System.out::println); // Output: apple, banana, cherry, date, elderberry

        // 5. sorted(): Sort in natural order
        System.out.println("\n5. sorted (natural order):");
        words.stream()
                .sorted()
                .forEach(System.out::println); // Output: apple, apple, banana, cherry, date, elderberry

        // 6. sorted(Comparator<T> comparator): Sort with custom comparator
        System.out.println("\n6. sorted (reverse order):");
        words.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println); // Output: elderberry, date, cherry, banana, apple, apple

        // 7. peek(Consumer<T> action): Perform action for debugging
        System.out.println("\n7. peek (debugging output):");
        words.stream()
                .peek(s -> System.out.println("Processing: " + s))
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: Processing: apple, APPLE, ..., Processing: elderberry, ELDERBERRY

        // 8. limit(long maxSize): Limit to first n elements
        System.out.println("\n8. limit (first 3 elements):");
        words.stream()
                .limit(3)
                .forEach(System.out::println); // Output: apple, banana, apple

        // 9. skip(long n): Skip first n elements
        System.out.println("\n9. skip (skip first 2 elements):");
        words.stream()
                .skip(2)
                .forEach(System.out::println); // Output: apple, cherry, date, elderberry

        // 10. takeWhile(Predicate<T> predicate): Take elements while predicate is true (Java 9+)
        System.out.println("\n10. takeWhile (numbers < 4):");
        numbers.stream()
                .takeWhile(n -> n < 4)
                .forEach(System.out::println); // Output: 1, 2, 2, 3

        // 11. dropWhile(Predicate<T> predicate): Skip elements while predicate is true (Java 9+)
        System.out.println("\n11. dropWhile (drop numbers < 4):");
        numbers.stream()
                .dropWhile(n -> n < 4)
                .forEach(System.out::println); // Output: 4, 5, 6

        // 12. mapMulti(BiConsumer<T, Consumer<R>> mapper): Expand elements (Java 16+)
        System.out.println("\n12. mapMulti (emit number and number*10):");
        numbers.stream()
                .mapMulti((n, consumer) -> {
                    consumer.accept(n);
                    consumer.accept(n * 10);
                })
                .forEach(System.out::println); // Output: 1, 10, 2, 20, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60

        // 13. mapMultiToInt(BiConsumer<T, IntConsumer> mapper): Expand to IntStream (Java 16+)
        System.out.println("\n13. mapMultiToInt (emit number and number*10):");
        numbers.stream()
                .mapMultiToInt((n, consumer) -> {
                    consumer.accept(n);
                    consumer.accept(n * 10);
                })
                .forEach(System.out::println); // Output: 1, 10, 2, 20, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60

        // 14. mapMultiToLong(BiConsumer<T, LongConsumer> mapper): Expand to LongStream (Java 16+)
        System.out.println("\n14. mapMultiToLong (emit number and number*10):");
        numbers.stream()
                .mapMultiToLong((n, consumer) -> {
                    consumer.accept(n);
                    consumer.accept(n * 10L);
                })
                .forEach(System.out::println); // Output: 1, 10, 2, 20, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60

        // 15. mapMultiToDouble(BiConsumer<T, DoubleConsumer> mapper): Expand to DoubleStream (Java 16+)
        System.out.println("\n15. mapMultiToDouble (emit number and number*10):");
        numbers.stream()
                .mapMultiToDouble((n, consumer) -> {
                    consumer.accept(n);
                    consumer.accept(n * 10.0);
                })
                .forEach(System.out::println); // Output: 1.0, 10.0, 2.0, 20.0, 2.0, 20.0, 3.0, 30.0, 4.0, 40.0, 5.0, 50.0, 6.0, 60.0

        // Example of chained intermediate operations
        System.out.println("\nChained Operations Example:");
        words.stream()
                .filter(s -> s.length() > 5) // Words longer than 5 characters
                .map(String::toUpperCase)    // Convert to uppercase
                .distinct()                  // Remove duplicates
                .sorted()                    // Sort alphabetically
                .limit(2)                    // Take first 2
                .forEach(System.out::println); // Output: ELDERBERRY
    }
}