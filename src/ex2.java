import java.util.ArrayDeque;
import java.util.Deque;

public class ex2 {
    public static void main(String[] args) {
        // Create a new ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // 1. addFirst(E e) - Adds element at the front
        deque.addFirst("First");
        System.out.println("After addFirst(First): " + deque);

        // 2. addLast(E e) - Adds element at the end
        deque.addLast("Last");
        System.out.println("After addLast(Last): " + deque);

        // 3. offerFirst(E e) - Offers element at the front
        deque.offerFirst("NewFirst");
        System.out.println("After offerFirst(NewFirst): " + deque);

        // 4. offerLast(E e) - Offers element at the end
        deque.offerLast("NewLast");
        System.out.println("After offerLast(NewLast): " + deque);

        // 5. removeFirst() - Removes and returns first element
        String removedFirst = deque.removeFirst();
        System.out.println("Removed first element: " + removedFirst);
        System.out.println("After removeFirst(): " + deque);

        // 6. removeLast() - Removes and returns last element
        String removedLast = deque.removeLast();
        System.out.println("Removed last element: " + removedLast);
        System.out.println("After removeLast(): " + deque);

        // Add elements for further operations
        deque.addFirst("A");
        deque.addLast("B");
        System.out.println("After adding A and B: " + deque);

        // 7. pollFirst() - Retrieves and removes first element, or returns null
        String polledFirst = deque.pollFirst();
        System.out.println("Polled first element: " + polledFirst);
        System.out.println("After pollFirst(): " + deque);

        // 8. pollLast() - Retrieves and removes last element, or returns null
        String polledLast = deque.pollLast();
        System.out.println("Polled last element: " + polledLast);
        System.out.println("After pollLast(): " + deque);

        // Add elements again
        deque.addFirst("X");
        deque.addLast("Y");
        deque.addLast("Z");
        System.out.println("After adding X, Y, Z: " + deque);

        // 9. getFirst() - Retrieves first element without removing
        String first = deque.getFirst();
        System.out.println("First element (getFirst): " + first);
        System.out.println("After getFirst(): " + deque);

        // 10. getLast() - Retrieves last element without removing
        String last = deque.getLast();
        System.out.println("Last element (getLast): " + last);
        System.out.println("After getLast(): " + deque);

        // 11. peekFirst() - Retrieves first element without removing, or returns null
        String peekFirst = deque.peekFirst();
        System.out.println("Peek first element: " + peekFirst);
        System.out.println("After peekFirst(): " + deque);

        // 12. peekLast() - Retrieves last element without removing, or returns null
        String peekLast = deque.peekLast();
        System.out.println("Peek last element: " + peekLast);
        System.out.println("After peekLast(): " + deque);

        // 13. push(E e) - Pushes element onto stack (adds to front)
        deque.push("StackTop");
        System.out.println("After push(StackTop): " + deque);

        // 14. pop() - Pops element from stack (removes from front)
        String popped = deque.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("After pop(): " + deque);

        // 15. removeFirstOccurrence(Object o) - Removes first occurrence
        deque.addLast("X"); // Add duplicate for testing
        boolean removedOcc = deque.removeFirstOccurrence("X");
        System.out.println("Removed first occurrence of X: " + removedOcc);
        System.out.println("After removeFirstOccurrence(X): " + deque);

        // 16. removeLastOccurrence(Object o) - Removes last occurrence
        deque.addLast("Y"); // Add duplicate for testing
        boolean removedLastOcc = deque.removeLastOccurrence("Y");
        System.out.println("Removed last occurrence of Y: " + removedLastOcc);
        System.out.println("After removeLastOccurrence(Y): " + deque);

        // 17. size() - Returns the size of deque
        System.out.println("Size of deque: " + deque.size());

        // 18. isEmpty() - Checks if deque is empty
        System.out.println("Is deque empty? " + deque.isEmpty());

        // 19. clear() - Removes all elements
        deque.clear();
        System.out.println("After clear(): " + deque);

        // 20. add(E e) - Adds element to the end (Queue operation)
        deque.add("QueueItem");
        System.out.println("After add(QueueItem): " + deque);

        // 21. contains(Object o) - Checks if element exists
        boolean contains = deque.contains("QueueItem");
        System.out.println("Contains QueueItem? " + contains);
    }
}
