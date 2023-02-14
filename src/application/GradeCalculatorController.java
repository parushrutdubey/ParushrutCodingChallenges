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
    Label projectErrorLabel;
    
    @FXML
    void calculateGrade(ActionEvent event) {
    	double coursegrade;
    	
    	String projectGrade= projectTextField.getText();
    	coursegrade=Double.parseDouble(projectGrade)*0.4;
    	System.out.print("Project Grade "+projectGrade);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    	int compulsory= compulsoryCoding.getValue();
    	double compweight=compulsory*1.5;//There are a total of 20 coding challenges for a weight of 25%. so each will be worth 1.25%
    	coursegrade= compweight+coursegrade;
    	System.out.print("Compulsory Coding Challenges passed "+compulsory);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    	int notcomp=optionalCoding.getValue();
    	double optionweight=notcomp*(1.5);
    	coursegrade=optionweight+coursegrade;
    	System.out.print("Optional Coding Challenges passed "+notcomp);
    	System.out.println(" Course Grade so far "+coursegrade);
    	
    			
    	double quizGrade= quizSlider.getValue();
    	double quizweight=quizGrade*3;
    	coursegrade=quizweight+coursegrade;
    	System.out.println("Quiz Grade "+quizGrade+" Course Grade so far "+coursegrade);

    	courseGradeLabel.setText("Your course grade is "+coursegrade);
    	//System.out.println("Button was clicked");

    }

}
