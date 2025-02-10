package weektasks;

public class StringProcessor {
	 public String reverseString(String str) {
	        return new StringBuilder(str).reverse().toString();
	    }

	 public int countOccurrences(String text, String sub) {
	        int count = 0;
	        int index = 0;
	        while ((index = text.indexOf(sub, index)) != -1) {
	            count++;
	            index += sub.length(); // Important: Avoid overlapping matches
	        }
	        return count;
	    }

	    /**
	     * Splits the string by spaces and capitalizes each word.
	     *
	     * @param str The string to split and capitalize.
	     * @return The formatted string.
	     */
	    public String splitAndCapitalize(String str) {
	        StringBuilder result = new StringBuilder();
	        String[] words = str.split("\\s+"); // Split by one or more spaces

	        for (String word : words) {
	            if (!word.isEmpty()) { // Handle potential empty strings after split
	                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
	            }
	        }
	        return result.toString().trim(); // Remove trailing space
	    }


	    public static void main(String[] args) {
	        StringProcessor processor = new StringProcessor();

	        String reversed = processor.reverseString("hello");
	        System.out.println("Reversed: " + reversed); // Output: olleh

	        int occurrences = processor.countOccurrences("This is a test test string", "test");
	        System.out.println("Occurrences: " + occurrences); // Output: 2

	        String formatted = processor.splitAndCapitalize("this is a test string");
	        System.out.println("Formatted: " + formatted); // Output: This Is A Test String
	    }

}
