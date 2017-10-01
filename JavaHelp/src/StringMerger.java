/* https://www.reddit.com/r/javahelp/comments/73b7qe/failed_interview_program/

The program was to input 2 strings and merge them.

For example sting a = "abc", string b = "def", would return "adbecf". 

I got it to work if both input strings were the same length but got out of bounds errors if the strings were different lengths.

Can anyone come up with a solution that will work for any string lengths? If chars were left over just append to the end. */

public class StringMerger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMerger("abc", "def");
		testMerger("ab", "opqrs");
		testMerger("a","12345");
		testMerger("12345","a");
		testMerger("","abc");
		testMerger("def","");
	}
	
	/**
	 * Helper procedure to test the merger function by printing user friendly text along with calling the merger function for the results.
	 * @param s1 The first string to be merged
	 * @param s2 The second String to be merged
	 */
	public static void testMerger(String s1, String s2) {
		System.out.println("String 1 is " + s1 + ", String 2 is " + s2 + ", the merged result is " + merger(s1,s2));
	}

	/**
	 * The main merger function that will merge the two strings together.
	 * @param s1 The first string to be merged
	 * @param s2 The second string to be merged
	 * @return The resulting merged string where the first character of the first string is followed by the first character of the second string followed by the second character of the first string and so on.
	 */
	public static String merger(String s1, String s2) {
		String results = "";
		
		// assume s2 is the smaller String (non-descending order)
		int min = s2.length();
		String bigger = s1;
		
		// if s1 turned out to be the smaller String, flip min and bigger around
		if(s1.length() < s2.length()) {
			min = s1.length();
			bigger = s2;
		}
		
		// traverse through the length of the smaller string, taking characters from both string
		for(int i = 0; i < min; i++)
			results = results + s1.charAt(i) + s2.charAt(i);
	
		// lastly append the remaining characters from the bigger string
		results = results + bigger.substring(min);
		
		return results;
	}
}
