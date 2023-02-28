module GradeCalculator {
	requires javafx.controls;
	requires javafx.fxml;
	requires junit;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
