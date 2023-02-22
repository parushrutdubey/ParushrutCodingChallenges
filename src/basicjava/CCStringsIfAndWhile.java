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

	public static int count(String s, String p) {
	
		return 0;
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
