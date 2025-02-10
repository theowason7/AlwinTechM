package weektasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramFinder {
	 public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList<>();
	        int n = s.length();
	        int m = p.length();

	        if (m > n) {
	            return result; // p cannot be an anagram if it's longer than s
	        }

	        // Character frequency maps for p and the current window in s
	        Map<Character, Integer> pMap = new HashMap<>();
	        Map<Character, Integer> sMap = new HashMap<>();

	        // Build frequency map for p
	        for (char c : p.toCharArray()) {
	            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
	        }

	        // Sliding window approach
	        for (int i = 0; i < n; i++) {
	            char currentChar = s.charAt(i);
	            sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);

	            if (i >= m) { // Remove the leftmost character from the window
	                char leftChar = s.charAt(i - m);
	                sMap.put(leftChar, sMap.get(leftChar) - 1);
	                if (sMap.get(leftChar) == 0) {
	                    sMap.remove(leftChar);
	                }
	            }

	            if (sMap.equals(pMap)) { // Check if the window is an anagram of p
	                result.add(i - m + 1); // Add the starting index of the anagram
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        AnagramFinder finder = new AnagramFinder();
	        String s = "cbaebabacd";
	        String p = "abc";
	        List<Integer> anagramIndices = finder.findAnagrams(s, p);
	        System.out.println("Anagram indices: " + anagramIndices); // Output: [0, 6]

	        s = "abab";
	        p = "ab";
	        anagramIndices = finder.findAnagrams(s, p);
	        System.out.println("Anagram indices: " + anagramIndices); // Output: [0, 1]

	        s = "wacat";
	        p = "cat";
	        anagramIndices = finder.findAnagrams(s, p);
	        System.out.println("Anagram indices: " + anagramIndices); // Output: [2]
	    }

}
