
import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        // Create a Scanner Object to read input
        Scanner scanner = new Scanner(System.in);

        //Reading a String Input
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("Enter the age");
        int age=scanner.nextInt();
        System.out.println(age);
        // 10. next().charAt(0) - Reads a single character
        System.out.print("Enter a single character: ");
        String charValue = scanner.next();
        System.out.println("You entered (char): " + charValue);
    }
}
