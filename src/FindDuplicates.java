import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {

    // Method 1: Find duplicates in an array using HashSet
    public static List<Integer> findDuplicatesWithSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return new ArrayList<>(duplicates);
    }

    // Method 2: Find duplicates with their frequency using HashMap
    public static Map<Integer, Integer> findDuplicatesWithFrequency(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Filter elements that appear more than once
        return frequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    // Method 3: Find duplicates in sorted array (space efficient)
    public static List<Integer> findDuplicatesInSortedArray(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                // Add only once per duplicate sequence
                if (duplicates.isEmpty() ||
                        duplicates.get(duplicates.size()-1) != arr[i]) {
                    duplicates.add(arr[i]);
                }
            }
        }

        return duplicates;
    }

    // Method 4: Find duplicates using Java 8 Streams
    public static List<Integer> findDuplicatesWithStreams(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Method 5: Find first duplicate in array
    public static Integer findFirstDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return null; // No duplicates found
    }

    // Method 6: Find duplicates in string array
    public static List<String> findDuplicateStrings(String[] arr) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>(); // Preserve order

        for (String str : arr) {
            if (!seen.add(str)) {
                duplicates.add(str);
            }
        }

        return new ArrayList<>(duplicates);
    }

    // Method 7: Find duplicates in positive number array (1 to n)
    // This uses array indices as markers - very space efficient
    public static List<Integer> findDuplicatesInRange(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                // Already seen this number
                duplicates.add(Math.abs(arr[i]));
            } else {
                // Mark as seen by making it negative
                arr[index] = -arr[index];
            }
        }

        // Restore original array (optional)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return duplicates;
    }

    public static void main(String[] args) {
        // Test data
        int[] arr1 = {1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 1};
        int[] arr2 = {1, 1, 2, 2, 3, 4, 5};
        String[] strArr = {"apple", "banana", "apple", "orange", "banana", "grape"};
        int[] rangeArr = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println("Original array: " + Arrays.toString(arr1));

        // Test Method 1
        System.out.println("\nMethod 1 - Using HashSet:");
        System.out.println("Duplicates: " + findDuplicatesWithSet(arr1));

        // Test Method 2
        System.out.println("\nMethod 2 - With Frequency:");
        System.out.println("Duplicates with count: " + findDuplicatesWithFrequency(arr1));

        // Test Method 3
        Arrays.sort(arr2);
        System.out.println("\nMethod 3 - Sorted array: " + Arrays.toString(arr2));
        System.out.println("Duplicates: " + findDuplicatesInSortedArray(arr2));

        // Test Method 4
        System.out.println("\nMethod 4 - Using Streams:");
        System.out.println("Duplicates: " + findDuplicatesWithStreams(arr1));

        // Test Method 5
        System.out.println("\nMethod 5 - First Duplicate:");
        System.out.println("First duplicate: " + findFirstDuplicate(arr1));

        // Test Method 6
        System.out.println("\nMethod 6 - String Array:");
        System.out.println("String duplicates: " + findDuplicateStrings(strArr));

        // Test Method 7
        System.out.println("\nMethod 7 - Range Array (1 to n):");
        System.out.println("Original: " + Arrays.toString(rangeArr));
        System.out.println("Duplicates: " + findDuplicatesInRange(rangeArr.clone()));
    }
}