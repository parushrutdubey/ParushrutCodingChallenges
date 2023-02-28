package basicjava;

public class CCStringsIfAndWhile {
	/**
	 * This method checks if the entered value is a digit or not.
	 * @param c a character which holds the value of the character to be tested
	 * @return Will return a true value if the character is a digit or else it will be false
	 */
	public static boolean isDigit(char c) {
		boolean testing=true;
		if(c=='0'||c=='1'||c=='9')
			testing=true;
		else
			testing=false;
		return testing;
	}
/**
 * This function counts the number of times a letter in the second argument appears in the original argument.
 * @param str It is the first sentence entered by the user to count the letters of 
 * @param chars It is the second sentence entered by the user to compare to the first sentence and count the letters which are in both strings
 * @return will return the value of the number of letters in the first sentence similar to the one in the first sentence.
 */
	public static int count(String str, String chars) {
		int count=0;
		String s1=str.toLowerCase();
		String s2=chars.toLowerCase();
		int l1=s1.length(),l2=s2.length();
		int i = 0;
		while (i < l1) {
		  int j = 0;
		  while (j < l2) {
		    if (s1.charAt(i) == s2.charAt(j)) {
		      count = count + 1;
		    }
		    j = j + 1;
		  }
		  i = i + 1;
		}
		
	
		return count;
	}
/**
 * This method will perform operations on a number entered by a user to find the smallest digit
 * @param num is the number entered by the user to find the smallest digit in 
 * @return will return a value of the smallest digit of the number entered by the user previously
 */
	public static int smallestDigit(int num) {
		if(num<0)
			num=num*-1;
		int test,smallest=num%10;
		
		while(num>0)
		{
			test=num%10;
			if(test<smallest) {
				 smallest=test;
			}
			num=num/10;
		}
		return smallest;
	}

}
