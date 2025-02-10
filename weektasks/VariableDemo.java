package weektasks;

import java.util.Arrays;

public class VariableDemo {
	 public static void modifyValues(int num, int[] arr) {
	        num = 20;
	        arr[0] = 100;
	    }

	    public static void main(String[] args) {
	        int num = 10;
	        int[] arr = {1, 2, 3};

	        modifyValues(num, arr);

	        System.out.println("Num: " + num); // Output: 10 (passed by value)
	        System.out.println("Arr: " + Arrays.toString(arr)); // Output: [100, 2, 3] (passed by reference)
	    }

}
