package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeCalculatorController {
	

	Stage applicationStage;

    @FXML
    private ChoiceBox<Integer> quizzesCompletedChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> optionalquizzesCompletedChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalCC;

    @FXML
    private ChoiceBox<Integer> requiredCC;

    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectGradeErrorLabel;

    @FXML
    private Label requiredQuizAvg;
    
    @FXML
    private Label optionalQuizAvg;
    
    @FXML
    private Button ReqcalculateGradeButton;
    
    @FXML
    private Button OptcalculateGradeButton;
    
    
    
   
    double averageQuizGrade = 0.0;
    Label quizErrorLabel = new Label();
    /**
     * This function is used to calculate the average grade of the required quiz grades
     * @param mainScene: after entering the grades and they are also valid then hitting the button would return the user to the main scene
     * @param quizGradeTextfields: this is where the grades for calculation come
     */
    void calculateAverageQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfields) {
    	
    	quizErrorLabel.setText("");
    	
    	double weightPerQuiz = .1/15.0;
    	
    	averageQuizGrade = 0.0;
    	boolean validquizGrade = false;
    	    	   	
    	for (TextField quizGradeTextfield : quizGradeTextfields) {
    		Grade quizGrade = new Grade(0,10,weightPerQuiz);
    		String errorMessage=quizGrade.setValue(quizGradeTextfield.getText());
    		if (!errorMessage.equals("")) {
    			validquizGrade=true;
    			quizErrorLabel.setText(errorMessage);
    		}	
    		averageQuizGrade+= quizGrade.getWeightedPercentageGrade();
    		requiredQuizAvg.setText(String.format("Quiz Average: %.2f", averageQuizGrade));
    	}
    	if(!validquizGrade) {
    		applicationStage.setScene(mainScene);
    	}
    }
   
    /**
     * This is the function which creates the new window for checking cmopulsory coding challenges
     * @param enterQuizGradeEvent It is the function which opens the window for the compulsory quiz grade with the TextFields based off the number of quizzes entered in the choicebox.
     */
    @FXML
    void getQuizGrades(ActionEvent enterQuizGradeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberofQuizzes = quizzesCompletedChoiceBox.getValue();
    	int rowsCreated = 0;
    	VBox quizGradeContainer = new VBox();
    	quizGradeContainer.getChildren().add(quizErrorLabel);
    	ArrayList<TextField> quizGradeTextfields = new ArrayList<TextField>();
    	
    	while (rowsCreated < numberofQuizzes) {
    	
	    	HBox rowContainer = new HBox();
	    	Label quizGradeLabel = new Label("Quiz Grade");
	    	TextField quizGradeTextfield = new TextField("0.0");
	    	Label quizGraderangeLabel = new Label("Enter Grade from 0-10");
	    	quizGradeTextfields.add(quizGradeTextfield);
	    	
	    	
	    	rowContainer.getChildren().addAll(quizGradeLabel, quizGradeTextfield, quizGraderangeLabel);
	    	rowsCreated++;
	    	
	    	quizGradeContainer.getChildren().add(rowContainer);
    	}

    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEven -> calculateAverageQuizGrade(mainScene, quizGradeTextfields));
    	quizGradeContainer.getChildren().add(doneButton);
    	
    	Scene quizGradesScene = new Scene(quizGradeContainer);
		applicationStage.setScene(quizGradesScene);
    }
    
    
    
    double averageOptionalQuizGrade = 0.0;
    /**
     * This function is used to calculate the average grade of the required quiz grades
     * @param mainScene: It is the main window which is displayed on pressing the DONE button
     * @param optionalquizGradeTextfields: This is the textfield where the user enters grades to be validated
     */
    void calculateAverageOptionalQuizGrade(Scene mainScene,ArrayList<TextField> optionalquizGradeTextfields) {
    	//applicationStage.setScene(mainScene);
    	quizErrorLabel.setText("");
    	double weightPerQuiz = .1/5.0;
    	averageOptionalQuizGrade = 0.0;
    	boolean validQuizGrade=false;
    	
	    
    	int size=optionalquizGradeTextfields.size();
	    
	    
	    
    	for (TextField optionalquizGradeTextfield : optionalquizGradeTextfields) {
    		
    		Grade optionalQuizGrade = new Grade(0,10,weightPerQuiz);
    		String errorMessage=optionalQuizGrade.setValue(optionalquizGradeTextfield.getText());
    		if(!errorMessage.equals("")) {
    			validQuizGrade=true;
    			quizErrorLabel.setText(errorMessage);
    		}
    		
	    	
	    	if(size<=5) {
	    		averageOptionalQuizGrade=averageOptionalQuizGrade+optionalQuizGrade.getWeightedPercentageGrade();
	    		optionalQuizAvg.setText(String.format("Quiz Average: %.2f", averageOptionalQuizGrade));
	    	}
	    	
	    	if(size>5) {
	    		double sum = gradeQuizSum(optionalquizGradeTextfields);
	    		averageOptionalQuizGrade=sum; 
	    	}
    	
    	}
    	if(!validQuizGrade) {
    		applicationStage.setScene(mainScene);
    	}
    }
    /**
     * This function creates an array which removes the lowest grades when there is more than 5 optional quiz grades.
     * @param optionalquizGradeTextfields: It generates an ArrayList of the optional quiz grade textfields to get values  
     * @return array returned is then used in the gradeQuizSum() to remove then add up the remaining quiz grades that are then used for calculating the average quiz grade and weighted grade
     */
    Double[] createGradesArray(ArrayList<TextField> optionalquizGradeTextfields) {		
 		int i=0;	
 		Double[] temp = new Double[optionalquizGradeTextfields.size()];
     	if (optionalquizGradeTextfields.size()>5) {   	
 	    	for(i=0;i<optionalquizGradeTextfields.size();i++) {
 	    		temp[i] = Double.parseDouble(optionalquizGradeTextfields.get(i).getText());
 	    	}
     	}
     	return temp;
 	}
    /**
     * This method removes the the lowest grade when there is more than 5 optional quiz grades entered. 
     * @param optionalquizGradeTextfields It is the parameter used to create the array used for the calculation
     * @return Returns the average sum of all the remaining optional quiz grades. 
     */
	private double gradeQuizSum(ArrayList<TextField> optionalquizGradeTextfields) {
		
		double sum =0.0;    	
		int i=0;
		int size = 0;
    	Double[] gradesArray = createGradesArray(optionalquizGradeTextfields);   	    	
	 	
	    		
    	Arrays.sort(gradesArray, Collections.reverseOrder());
    	System.out.println("the length is: "+gradesArray.length);
    	if(gradesArray.length==6) {
    		size=gradesArray.length-1;
    	}
    	if(gradesArray.length==7) {
    		size=(gradesArray.length)-2;
    	}
    	System.out.println("the size is: "+size);
    	for (i=0;i<size;i++) {
    		sum = sum + gradesArray[i]; 
		
			}
    	optionalQuizAvg.setText(String.format("Quiz Average: %.2f", sum/5.0));
    	sum = (sum/5.0);
    	System.out.println("the sum is:"+sum);
		return sum;
	}

	/**
	 * This is the optional quiz grade window where the user enters grades in textfields.
	 * @param optionalQuizGradeEvent: This opens the window from the main scene to enter the grades of optional quiz based on the number of quizzes entered in the choicebox.
	 */
	@FXML
    void getoptionalQuizGrades(ActionEvent optionalQuizGradeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberofoptionalQuizzes = optionalquizzesCompletedChoiceBox.getValue();
    	int rowsCreated = 0;
    	VBox optionalquizGradeContainer = new VBox();
    	optionalquizGradeContainer.getChildren().add(quizErrorLabel);
    	ArrayList<TextField> optionalquizGradeTextfields = new ArrayList<TextField>();
    	
    	while(rowsCreated<numberofoptionalQuizzes) {
	    	HBox rowContainer = new HBox();
	    	Label optionalquizGradeLabel = new Label("Optional Quiz Grade");
	    	TextField optionalquizGradeTextfield = new TextField("0.0");
	    	Label quizGraderangeLabel = new Label(" Enter Grade from 0-10");
	    	optionalquizGradeTextfields.add(optionalquizGradeTextfield);
	    	
	    	rowContainer.getChildren().addAll(optionalquizGradeLabel, optionalquizGradeTextfield,quizGraderangeLabel );
	    	rowsCreated++;
	    	
	    	optionalquizGradeContainer.getChildren().add(rowContainer);
    	}
    	
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateAverageOptionalQuizGrade(mainScene, optionalquizGradeTextfields));
    	optionalquizGradeContainer.getChildren().addAll(doneButton);
    	
    	Scene quizgradeScene = new Scene(optionalquizGradeContainer);
    	applicationStage.setScene(quizgradeScene);
    	
    }
    
    /**
     * This is the main function which calls the other functions to calculate the final grade.
     * @param event: The event is the calculation of grades which happens on pressing the calculate grade button in the main window.
     */
    @FXML
    void calculateGrade(ActionEvent event) {
    	//Clears the error messages
    	projectGradeErrorLabel.setText("");
  	
    	
    	Grade projectGrade = new Grade(0.0,100,.5);
    	projectGradeErrorLabel.setText(projectGrade.setValue(projectGradeTextfield.getText()));
   	
    	Grade requiredQuizGrade = new Grade(averageQuizGrade,10,.1875);
    	
    	Grade optionalQuizGrade = new Grade(averageOptionalQuizGrade,10,.0625);
    	
    	Grade requiredCCGrade = new Grade(requiredCC.getValue(),15,.1875);
    	
    	Grade optionalCCGrade = new Grade(optionalCC.getValue(),5,.0625);
   	
    	double courseGrade= projectGrade.getWeightedPercentageGrade()+
    			requiredQuizGrade.getWeightedPercentageGrade()+
    			optionalQuizGrade.getWeightedPercentageGrade()+
    			requiredCCGrade.getWeightedPercentageGrade()+
    			optionalCCGrade.getWeightedPercentageGrade();

    	courseGradeLabel.setText(String.format("Your course grade is: %.2f", courseGrade));
    }

}
