package Strings.Basics;

//A pangram is a sentence containing every letter in the English Alphabet.(A to Z)
class Pangram {

	public static boolean checkPangram(String str) { //A=65 to Z=90; a=97 to z=122
		boolean[] alphabets = new boolean[26];
		int index = 0;
		str = str.toLowerCase();
		for (char c : str.toCharArray()) {  //for (int i = 0; i < str.length(); i++)
			if (c >= 'a' && c <= 'z') {
				// for lowercase character, subtract 'a' to get index of that character.
				index = c - 'a'; //or mark[c - 'a'] = true;
			}
			alphabets[index] = true;
		}

		// Check if all 26 letters are present
		for (boolean present : alphabets) {
			if (!present) return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";

		if (checkPangram(str))
			System.out.print("It's a PANGRAM");
		else
			System.out.print("Not a PANGRAM");
	}
}
