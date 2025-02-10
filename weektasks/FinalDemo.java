package weektasks;

public class FinalDemo {
	final int finalVariable = 10; // Final variable

    final void finalMethod() { // Final method
        System.out.println("This is a final method.");
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo();
        // demo.finalVariable = 20; // Compile-time error: Cannot assign a value to a final variable
        demo.finalMethod();
    }

}
final class FinalClass { // Final class
    // ...
}
