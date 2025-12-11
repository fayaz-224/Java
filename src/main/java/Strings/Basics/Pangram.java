package Strings.Basics;

//A pangram is a sentence containing every letter in the English Alphabet.(A to Z)
class Pangram {

	public static boolean checkPangram(String str) { //A=65 to Z=90; a=97 to z=122
		if (str == null) return false;

		boolean[] alphabets = new boolean[26]; //freq array
		int count = 0; //if not count use for loop as below

		for (char c : str.toLowerCase().toCharArray()) {  //for (int i = 0; i < str.length(); i++)
			if (c >= 'a' && c <= 'z') {  //if (Character.isLetter(c))
				// for lowercase character, subtract 'a' to get index of that character.
				int index = c - 'a';
				if (!alphabets[index]) {
					alphabets[index] = true;
					count++;
					if (count == 26) return true; // all letters found
				}
			}
		}
		return false;

//		for (boolean present : alphabets) {
//			if (!present) return false;
//		}
//		return true;
	}

	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";

		System.out.print(checkPangram(str));
	}
}
