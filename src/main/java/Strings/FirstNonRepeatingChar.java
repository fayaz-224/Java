package Strings;

import java.util.HashMap;
import java.util.Map;

//using streams is in StreamApi class
public class FirstNonRepeatingChar {

    public static char firstNonRepeatingCharacter(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Build frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        // Find first non-repeating character
        for (char c : s.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }
        // If no non-repeating character found, return a default value (e.g., '\0')
        return '\0';
    }

    public static void main(String[] args) {
        String input = "fayazflash";
        char firstNonRepeating = firstNonRepeatingCharacter(input);
        System.out.println("First non-repeating character in '" + input + "': " + firstNonRepeating);
    }
}

/*
public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		String string = "geeksforgeeks";
		int index = -1;
		char fnc = '';

        if(string.length()==0){
            System.out.println("EMPTY STRING");
        }
	
		for (char i : string.toCharArray()) {
			if (string.indexOf(i) == string.lastIndexOf(i)) {
				fnc = i;
				break;
			} else {
				index += 1;
			}
		}
		if (index == string.length()-1) {
			System.out.println("All characters are repeating");
		} else {
			System.out.println("First non-repeating character is " + fnc);
		}
	}
}

 */