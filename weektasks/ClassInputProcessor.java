package weektasks;
import java.util.*;


public class ClassInputProcessor {
	public static void processInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            if (num == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            double reciprocal = 1.0 / num;
            System.out.println("Reciprocal: " + reciprocal);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    }

    public static void main(String[] args) {
        processInput();
    }

}
