package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorController {

    @FXML
    private TextField projectTextField;

    @FXML
    private ChoiceBox<Integer> optionalCoding;

    @FXML
    private ChoiceBox<Integer> compulsoryCoding;

    @FXML
    private Slider quizSlider;

    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectErrorLabel;
    
    /**
     * Convert the value entered to a double value. This method will verify that the value entered is a valid 
     * percentage grade between 0 and 100. If the value is valid then 
     * @param valueEntered a String that holds a value entered by the user intended to be a project grade
     * @return the project value entered by the user if it not is not a valid percentage grade then the method
     * will return 0.0 as the project grade instead. 
     */
    double getProjectGrade(String valueEntered)
    {
    	boolean validProjectGrade=true;
    	for(char c: valueEntered.toCharArray())
    		//This is for checking if the decimal entered is valid or not
    	{
    		if(!Character.isDigit(c)&& c!='.')
    			//Check if character is a digit
    		{
    			validProjectGrade=false;
    			projectErrorLabel.setText("Do not use "+c+" in a project grade. Make sure it is a number");
    		}
    		int point=1;//used to count the number of decimal points
    		if(c=='.')
    		{
    			point=point+1;
    		}
    		if(point>1)
    			projectErrorLabel.setText("Do not use "+point+" decimal points in a project grade.");
    	}
    	
    	double projectGrade=0.0;
    	if(validProjectGrade) {
    		projectGrade=Double.parseDouble(valueEntered);
    		//Convert the string entered to double if it is a valid number.
    	}
    	if(projectGrade<0 ||projectGrade>100)
    		//Checks if the grade entered is within the boundary of 0 and 100
    	{
    		projectErrorLabel.setText("Project grade must be between 0 and 100. Invalid Input!!!");
    		projectGrade=0;
    	}
    	
    	return projectGrade;
    }
    
    @FXML
    /**
     * This will calculate the value of course grade after the button is pressed. It will pass the value
     * of the project grade to the function getProjectGrade for verification of it being a decimal and then 
     * on returning will add it to the course grade variable on the basis it is valid or not. The Coding Challenge
     * and quiz grades are calculated normally based on the scores in each of those components. 
     * @param event is the starter for running the code on pressing the button in the window of the GUI
     */
    void calculateGrade(ActionEvent event) {
   
    	projectErrorLabel.setText("");
    	//Clear all error messages
    	double coursegrade=0.0;
    	
    	String projectValueEntered=projectTextField.getText();
    	
    	double projectGrade=getProjectGrade(projectValueEntered);
    	
    	coursegrade=coursegrade+projectGrade*0.5;
    
    	System.out.print("Project Grade "+projectGrade);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    	int compulsory= compulsoryCoding.getValue();
    	double compweight=compulsory*1.25;//There are a total of 20 coding challenges for a weight of 25%. so each will be worth 1.25%
    	coursegrade= compweight+coursegrade;
    	System.out.print("Compulsory Coding Challenges passed "+compulsory);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    	int notcomp=optionalCoding.getValue();
    	double optionweight=notcomp*(1.25);
    	coursegrade=optionweight+coursegrade;
    	System.out.print("Optional Coding Challenges passed "+notcomp);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    			
    	double quizGrade= quizSlider.getValue();
    	double quizweight=quizGrade*2.5;
    	coursegrade=quizweight+coursegrade;
    	System.out.println("Quiz Grade "+quizGrade+" Course Grade so far "+coursegrade);

    	courseGradeLabel.setText("Your course grade is "+coursegrade);
    	//System.out.println("Button was clicked");

    }

}
