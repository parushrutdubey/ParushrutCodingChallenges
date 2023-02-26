package basicjava;

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
		int i,j;
		String s;
		for(i=0;i<strArray.length;i++)//By using Bubble Sort technique
		{
			for(j=i+1;j<strArray.length;j++)
			{
				if(strArray[i].compareToIgnoreCase(strArray[j])>0)//compareToIgnoreCase is used rather than compareTo as we want it to sort only based off the alphabets and not the case which would depend on the ASCII number of the letter
				{
					s=strArray[i];
					strArray[i]=strArray[j];
					strArray[j]=s;
				}
			}
		}
	}

}
