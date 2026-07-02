package InputOutput;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        /*
        Methods of Scanner class to read input from console:
        1. next() - reads a single word from the console.
        2. nextLine() - reads a line of text from the console.
        3. nextInt() - reads an integer from the console.
        4. nextDouble() - reads a double value from the console.
        5. nextBoolean() - reads a boolean value from the console.
        etc...

        Note: Scanner class is part of java.util package.        
        */

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello " + name);

        sc.close(); // Closing the scanner object to prevent resource leak
    }
}
