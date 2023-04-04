package application;

public class Grade {
	double value;
	int maxValue=100;
	double weight;
	/**
	 * this function holds the values for each of the different components value, max value, and the weight of that component 
	 * @param gradeValue: the raw value given by the component
	 * @param maxPossibleValue: the maxim value that is possible for the component
	 * @param weightTowardsCourseGrade: the weight that the component holds in the overall course
	 */
	public Grade(double gradeValue,int maxPossibleValue,double weightTowardsCourseGrade){
		value= gradeValue;
		maxValue=maxPossibleValue;
		weight=weightTowardsCourseGrade;
	}
	/**
	 * this function is used to calculate the weighted grade of the components that are then added together to get the total course grade
	 * @return the function returns the weighted grade of the component
	 */
	public double getWeightedPercentageGrade() {
		
		return value*100*weight/maxValue;
	}

	
	/**
	 * this is where the input from text fields is checked to see if they are valid inputs, they aren't a valid input then an appropriate error message is displayed.
	 * @param valueAsString: the input from the text field is converted to a string then checked to see if it is a valid input or not.
	 * @return is returns an error message that is then displayed to indicate why the input is incorrect.
	 */
	String setValue(String valueAsString) {
		//Checks that the string entered by the user is a valid decimal number
    	String Decimal = ".";
    	String errorMessage = "";
    	boolean validProjectGrade = true;
    	for (char c: valueAsString.toCharArray()) {
    		//Checks if the character is a digit
    		
    		/**
    		 * Checks to see if the value entered has a decimal or characters, if it has a decimal and no characters it will return true
    		 * if the value entered has a character it will return false even if it has a decimal.
    		 */
    		if (!Character.isDigit(c) & !valueAsString.contains(Decimal)) {
    			validProjectGrade = false;
    			errorMessage=String.format("Do not use %c in grade value. Make sure to enter a number.", c);
    		}
    		/**
    		 * if the value entered has a decimal, if the value entered has a decimal then it converts it to an array 
    		 * then checks if it has more than one decimal or not, if it has more than one decimal then the user will receive an error message
    		 */
    		if(valueAsString.contains(Decimal)) { 
    			
    			char[] valueAsStringArray = valueAsString.toCharArray();
    			
    			int count = 0;
    			
    			
    			int size= valueAsStringArray.length;
    			for(int i = 0; i < size ;i++) {
    				
    				
    				if (valueAsStringArray[i] == '.' ) {
    					count=count+1;
    					
    					if(count == 1) {
    						
    						validProjectGrade = true;
    					}
    					if (count>1) {
    						
    						validProjectGrade = false;
    						errorMessage="Make sure to only enter a single decimal.";
    					
    					}
    				}
    			}

    		}
    	}
    	
    	//Convert the string entered by the user to a double if the input is a valid number
    	//Otherwise the project grade will default to zero
    	
    	if (validProjectGrade) {
    		value = Double.parseDouble(valueAsString);
    	}
    	//Assuming that project is worth 50% towards course grade

    	//Check if the number entered by the user is a valid percentage grade
    	//If valid, include it in the grade computation
    	if (value < 0 || value > maxValue) {
    		errorMessage=String.format("Grade should be between 0 and %d", maxValue);
    		value = 0.0;
    		
    	}
    
    	
    	return errorMessage;
	}

	
	

}
