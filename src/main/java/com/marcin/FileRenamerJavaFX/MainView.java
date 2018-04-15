package com.marcin.FileRenamerJavaFX;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainView {
	private GridPane grid;
	private Button searchFilesButton;
	private Button renameButton;
	private TextField userInputField;
	private Label finalInfo;
	private Label finalInfo2;
	private Label finalInfo3;
	private Label appInfo;
	private AlertDialogs alerts;
	
	@Autowired                             // unnecessary if 1 constructor only
	public MainView(AlertDialogs alerts) {
		this.alerts = alerts;
		this.grid = new GridPane();	
		grid.setPadding(new Insets(30, 10, 10, 10));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
	}

	public void initView(Stage primaryStage) {				
		Scene scene = new Scene(grid, 800, 600);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
		primaryStage.setScene(scene);
		primaryStage.show();
		createContent(scene);
	}
	
	public void createContent(Scene scene) {		
		searchFilesButton = new Button("Search for files");
		searchFilesButton.setPrefSize(150, 50);
		searchFilesButton.setDefaultButton(true);
		searchFilesButton.setFont(Font.font("ARIAL", 16.0));
		searchFilesButton.setAlignment(Pos.CENTER);
		searchFilesButton.setLayoutX(550);
		searchFilesButton.setLayoutY(250);
		
		finalInfo = new Label();
		finalInfo.setPrefSize(400, 70);
		finalInfo.setFont(Font.font("ARIAL", 16));
		finalInfo.setAlignment(Pos.TOP_CENTER);
		String currentYear = LocalDate.now().toString().substring(0, 4);
		finalInfo.setText("Set file name using regular text e.g. Summer" + currentYear + ".\n"
				+ "Choose numbering position.\n"
				+ "Choose extras from the right optionally."); 
		
		appInfo = new Label();
		appInfo.setPrefSize(400, 50);
		appInfo.setFont(Font.font("ARIAL", 16));
		appInfo.setAlignment(Pos.TOP_CENTER);
		appInfo.setText("TODO: Application info."); 
				
		renameButton = new Button("Rename");
		renameButton.setPrefSize(150, 40);
		renameButton.setDefaultButton(true);
		renameButton.setFont(Font.font("ARIAL", 16.0));
		renameButton.setAlignment(Pos.CENTER);
		
	    // defining the searching bar text field
	    userInputField = new TextField();
	    userInputField.setPromptText("Enter your filename schema");
	    userInputField.setPrefColumnCount(15);   // maximum number of characters it can display at one time - doesn't work?
	    userInputField.getText();                // the text data entered by a user into the text fields can be obtained by the getText() 
	    
	    GridPane.setConstraints(searchFilesButton, 0, 1, 5, 1, HPos.CENTER, VPos.CENTER);
	    GridPane.setConstraints(finalInfo, 0, 2, 5, 5, HPos.CENTER, VPos.CENTER);  
	    GridPane.setConstraints(userInputField, 0, 6, 5, 8, HPos.CENTER, VPos.CENTER);
	    GridPane.setConstraints(appInfo, 0, 9, 5, 11, HPos.CENTER, VPos.CENTER);
	    GridPane.setConstraints(renameButton, 0, 12, 5, 12, HPos.CENTER, VPos.CENTER);
	   	        
		grid.getChildren().addAll(searchFilesButton, finalInfo, userInputField, appInfo, renameButton);
	}

	/**
	 * @return the openFileDialog
	 */
	public Button getSearchFilesButton() {
		return searchFilesButton;
	}

	/**
	 * @param openFileDialog the openFileDialog to set
	 */
	public void setSearchFilesButton(Button openFileDialog) {
		this.searchFilesButton = openFileDialog;
	}

	/**
	 * @return the searchBar
	 */
	public TextField getUserInputField() {
		return userInputField;
	}

	/**
	 * @param searchBar the searchBar to set
	 */
	public void setUserInputField(TextField searchBar) {
		this.userInputField = searchBar;
	}

	/**
	 * @return the renameButton
	 */
	public Button getRenameButton() {
		return renameButton;
	}

	/**
	 * @param renameButton the renameButton to set
	 */
	public void setRenameButton(Button renameButton) {
		this.renameButton = renameButton;
	}

	/**
	 * @return the alerts
	 */
	public AlertDialogs getAlerts() {
		return alerts;
	}

	/**
	 * @param alerts the alerts to set
	 */
	public void setAlerts(AlertDialogs alerts) {
		this.alerts = alerts;
	}

	
	
}
