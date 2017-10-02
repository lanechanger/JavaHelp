/*
 https://www.reddit.com/r/javahelp/comments/73hrnl/n_i_i_i/
 
I have to write a program that finds out if the integer N the user inputs equals i * i + i

Ex: if the user enters (2) because 1 * 1 + 1 = 2, or (6) because 2 * 2 + 2 = 6

I have the code pretty much correct but it only says that 2 is correct, once I enter 6 it says it's not correct. I'm using the i++ but it doesn't execute right.

Any help?

 */
public class CementGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCementer(0);
		testCementer(1);
		testCementer(2);
		testCementer(5);
		testCementer(6);
		testCementer(12);
		testCementer(20);
		testCementer(30);
		testCementer(10000);
		testCementer(10100);
		testCementer(9999*9999+9999);
		testCementer(9999*9999+9998);
	}
	
	/**
	 * Helper function to test cementer
	 * Assumption is that the input is an integer and is not negative
	 * @param N the input string to be tested (see cementer)
	 */
	public static void testCementer(long N) {
		if(N >= 0)
			System.out.println("N is " + N + " and i is " + cementer(N) + " (-1 means no such i exists)");
	}
	
	/**
	 * Takes an input integer >= 0 as the input and returns the cemented value i where N = i * i + i if such a value exists.
	 * @param N an integer >= 0 where we're trying to find the cemented value
	 * @return returns the number i where N = i * i + i and a -1 if no such i exists
	 */
	public static long cementer(long N) {
		// Observe that sqrt(N) == sqrt(i*i+i) > sqrt(i^2) == i which means sqrt(N) is an upperbound on what i can be
		// And since N is determined mostly by i^2 especially as i grows that sqrt(N) is a good place to start guessing from
		long guess = (long) Math.sqrt(N);
		long solution;
		 
		// note that loop will always exit since we start from an upperbound and work our way down and return a value if we're too low
		while(true) {
			solution = guess * guess + guess;
		
			// if a cemented value is found, return it, and if we our guess came up with a value that is short then we will never find one
			if(solution == N) 
				return guess;
			else if(solution < N)
				return -1;
			
			guess--;
		}	
	}
}
