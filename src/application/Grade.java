package application;

public class Grade {
	double value;
	int maxValue=100;
	double weight;
	/**
	 * This constructor initiates the values of value, maxValue, weight
	 * @param gradeValue: The grade entered
	 * @param maxPossibleValue: The maximum value that is possible for the specific component
	 * @param weightTowardsCourseGrade: The weight of the specific component which has to be calculated
	 */
	public Grade(double gradeValue,int maxPossibleValue,double weightTowardsCourseGrade){
		value= gradeValue;
		maxValue=maxPossibleValue;
		weight=weightTowardsCourseGrade;
	}
	/**
	 * This method calculates the wieghted percentage of the component to add to the course grade.
	 * @return The method returns the grade after assinging it it's weight of the final course grade.
	 */
	public double getWeightedPercentageGrade() {
		
		return value*100*weight/maxValue;
	}

	
	/**
	 * This is where the inputs of the Textfields(Project and Quiz)have valid inputs and show the error messages for wrong inputs.
	 * @param valueAsString: The input from the Textfield is converted to string to perform operations on it for checking the validity of input.
	 * @return It returns the error which has been detected if, there is none then it returns nothing
	 */
	String setValue(String valueAsString) {
		//Checks that the string entered by the user is a valid decimal number
    	String Decimal = ".";
    	String errorMessage = "";
    	boolean validProjectGrade = true;
    	for (char c: valueAsString.toCharArray()) {
    		if (!Character.isDigit(c) & !valueAsString.contains(Decimal)) {
    			validProjectGrade = false;
    			errorMessage=String.format("Do not use %c in grade value. Make sure to enter a number.", c);
    		}
    		
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
    	
    	
    	if (validProjectGrade) {
    		value = Double.parseDouble(valueAsString);
    	}
    	if (value < 0 || value > maxValue) {
    		errorMessage=String.format("Grade should be between 0 and %d", maxValue);
    		value = 0.0;
    		
    	}
    
    	
    	return errorMessage;
	}

	
	

}
