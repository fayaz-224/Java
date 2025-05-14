package Strings.Basics;

//A pangram is a sentence containing every letter in the English Alphabet.(A to Z)
class Pangram {

	public static boolean checkPangram(String str) { //A=65 to Z=90; a=97 to z=122
		boolean[] mark = new boolean[26];
		int index = 0;

		for (int i = 0; i < str.length(); i++) {
			// If uppercase character, subtract 'A' to get index.
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				index = str.charAt(i) - 'A';	// (or) mark[str.charAt(i) - 'A'] = true;

			// If lowercase character, subtract 'a' to get index.
			else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
				index = str.charAt(i) - 'a';
			else
				continue; // If this is not an alphabet

			mark[index] = true;
		}

		for (int i = 0; i <= 25; i++) {
			if (!mark[i])  //mark[i] != true
				return false;    //to find missing characters: arrList.add((char)(i + 'a')); return arrList;
		}
		return true;
	}

	
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";

		if (checkPangram(str))
			System.out.print(str + " - pangram");
		else
			System.out.print(str + " - not a pangram");
	}
}
