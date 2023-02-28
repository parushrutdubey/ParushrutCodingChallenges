package basicjava;

import java.util.Arrays;

public class CCArrays {
	/**
	 * This method checks the character array and replaces a specific character with another specific character
	 * @param charArray is the Character array provided to us 
	 * @param toReplace is the letter which has to be replaced
	 * @param replaceWith is the letter which has to be replaced by 
	 */
	public static void replace(char[] charArray, char toReplace, char replaceWith)
	{
		int i;
		char replace=Character.toUpperCase(toReplace);//Changed to uppercase so that the case of letter does not matter in changing.
		for(i=0;i<charArray.length;i++)
		{
			char s=Character.toUpperCase(charArray[i]);
			if(s==replace)
				charArray[i]=replaceWith;
		}
	}
	
	/**
	 * This method sorts the arrays in Alphabetical order regardless of case of letters.
	 * @param strArray is the array of sentences which have to be sorted
	 */
	public static void sortAlphabetic(String[] strArray)
	{
        Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);// The Case Insensitive Order function sorts the array without taking the case into consideration 
	}

}
