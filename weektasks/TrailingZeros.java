package weektasks;

public class TrailingZeros {
	 public static int countTrailingZeros(int n) {
	        int count = 0;
	        for (int i = 5; n / i >= 1; i *= 5) {
	            count += n / i;
	        }
	        return count;
	    }

	    public static void main(String[] args) {
	        int n = 100;
	        int zeros = countTrailingZeros(n);
	        System.out.println("Trailing zeros in " + n + "! : " + zeros);
	    }

}
