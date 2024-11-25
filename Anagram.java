/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processedStr1 = preProcess(str1);
		String processedStr2 = preProcess(str2);
		String ans1 = "";
		String ans2 = "";
		// ignore spaces (the testanagram wanted to keep them)
		for (int i = 0; i < processedStr1.length(); i++) {
			char ch = processedStr1.charAt(i);
			if (ch != ' ') { // Ignore spaces
				ans1 += ch;
			}
		}
		for (int j = 0; j < processedStr2.length(); j++) {
			char ch = processedStr2.charAt(j);
			if (ch != ' ') { // Ignore spaces
				ans2 += ch;
			}
		}
		if (ans2.length() != ans1.length()) {
			return false;
	}
	for (int m = 0; m < ans1.length(); m++) {
        char currentChar = ans1.charAt(m);
		int index = ans2.indexOf(currentChar); // finding the matching char at str2
		if (index == -1) {
			return false;
		} else {
			ans2 = ans2.substring(0, index) + ans2.substring(index + 1);
		}
	}
	return true;

}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		//convert the first letter to lowercase
		String ans = "";
		if (str.length() > 0) {
			char firstLetter = str.charAt(0);
			if (firstLetter >= 'A' && firstLetter <= 'Z') {
				ans += (char) (firstLetter + 32); // lower case
			} else if ( firstLetter >= 'a' && firstLetter <= 'z') {
				ans += firstLetter; // keep lowercase the same
			}
		}
		int i = 1;
		while (i < str.length()) {
			char ch = str.charAt(i);
			int ascii = (int) ch;
			if (ch == ' ') {
				ans += ch;
			} else if (ch >= 'A' && ch <= 'Z' ){
				ans += (char) (ch + 32); // lower case	
			} else if (ascii >= 33 && ascii <= 47 || ascii == 58 || ascii == 64 || ascii == 96) {
				i++;
			} else {
				ans += ch; // keep lowercase the same
			}
			i++;
		}	return ans; 	
	}
		
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String ans = str;
		String output = "";
		 // until all characters are used
		while (ans.length() > 0) {
			int randomIndex = (int) (Math.random() * ans.length());
			output += ans.charAt(randomIndex);
			ans = ans.substring(0, randomIndex) + ans.substring(randomIndex + 1);
		}
		return output;
	}
}
