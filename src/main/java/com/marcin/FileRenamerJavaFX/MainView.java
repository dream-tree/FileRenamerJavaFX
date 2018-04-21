package com.marcin.FileRenamerJavaFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainView {
	private GridPane grid;
	private Button selectFilesButton;
	private Button renameButton;
	private TextField userInputField;
	private Label finalInfo;
	private ToggleGroup toggleGroup;
	private MenuBar menuBar;
	@Autowired
	private AlertDialogs alerts;
	@Autowired
	private Wallpaper wallpaper;
	
	@Autowired                             // unnecessary if 1 constructor only
	public MainView() {
		this.grid = new GridPane();	
		grid.setPadding(new Insets(0, 0, 20, 0));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPrefSize(800, 600);
//		grid.setGridLinesVisible(true);
	}

	public void initView(Stage primaryStage) {				
		Scene scene = new Scene(grid, 800, 600, Color.RED);
		grid.setBackground(new Background(wallpaper.setWallpaper()));
		primaryStage.setScene(scene);
		primaryStage.show();
		createContent(scene);
	}

	public void createContent(Scene scene) {			
		MenuBar menuBar = addMenuBar();
		selectFilesButton = new Button("Search for files");
		selectFilesButton.setPrefSize(150, 50);
		selectFilesButton.setDefaultButton(true);
		selectFilesButton.setFont(Font.font("ARIAL", 16.0));
		selectFilesButton.setAlignment(Pos.CENTER);
		
		finalInfo = new Label();
		finalInfo.setPrefSize(400, 70);
		finalInfo.setFont(Font.font("ARIAL", 16));
		finalInfo.setAlignment(Pos.TOP_CENTER);
		String currentYear = LocalDate.now().toString().substring(0, 4);
		finalInfo.setText("Set your file name schema, e.g. Summer2018" + currentYear + ".\n"
				+ "Choose numbering position.\n"
				+ "Enjoy your photo collection!"); 
		finalInfo.setTextAlignment(TextAlignment.CENTER);
		
		userInputField = new TextField();
		userInputField.setMaxWidth(400);
		userInputField.setPromptText("Enter your filename schema");
		userInputField.setPrefColumnCount(15);   // maximum number of characters it can display at one time - doesn't work?
		userInputField.getText();                // the text data entered by a user into the text fields can be obtained by the getText() 
							
		GridPane gridWithRadioButtons = new GridPane();		
		toggleGroup = new ToggleGroup();	
		RadioButton rb1 = new RadioButton();
		RadioButton rb2 = new RadioButton();
		rb1.setPrefWidth(220);
		Label emptyLabelLeft1 = new Label();
		emptyLabelLeft1.setPrefWidth(280);
		gridWithRadioButtons.add(emptyLabelLeft1, 0, 0);
		gridWithRadioButtons.add(rb1, 1, 0);
		gridWithRadioButtons.add(rb2, 2, 0);
		rb1.setUserData(0);
		rb2.setUserData(1);
		rb1.setToggleGroup(toggleGroup);
		rb2.setToggleGroup(toggleGroup);
		rb1.setVisible(true);
		rb2.setVisible(true);  
        
		GridPane gridWithButtonDespription = new GridPane();
		Label emptyLabelLeft2 = new Label();
		emptyLabelLeft2.setPrefWidth(200);
		Label numberingTextLeft = new Label("start numbering from left");
		Label numberingTextRight = new Label("start numbering from right");
		numberingTextLeft.setPrefWidth(220);
		gridWithButtonDespription.add(emptyLabelLeft2, 0, 1);
		gridWithButtonDespription.add(numberingTextLeft, 1, 1);
		gridWithButtonDespription.add(numberingTextRight, 2, 1);
	
		renameButton = new Button("Rename");
		renameButton.setPrefSize(150, 50);
		renameButton.setDefaultButton(true);
		renameButton.setFont(Font.font("ARIAL", 16.0));
		renameButton.setAlignment(Pos.CENTER);
			    
		GridPane.setConstraints(menuBar, 0, 0);
		GridPane.setConstraints(selectFilesButton, 0, 13);
		GridPane.setConstraints(finalInfo, 0, 14);
		GridPane.setConstraints(userInputField, 0, 15);
		GridPane.setConstraints(gridWithRadioButtons, 0, 17);
		GridPane.setConstraints(gridWithButtonDespription, 0, 18);
		GridPane.setConstraints(renameButton, 0, 21);
	    
		GridPane.setHalignment(selectFilesButton, HPos.CENTER);	    
		GridPane.setHalignment(finalInfo, HPos.CENTER);    
		GridPane.setHalignment(userInputField, HPos.CENTER);   
		GridPane.setHalignment(gridWithRadioButtons, HPos.CENTER);
		GridPane.setHalignment(gridWithButtonDespription, HPos.CENTER); 
		GridPane.setHalignment(renameButton, HPos.CENTER);
	    
		grid.getChildren().addAll(menuBar, selectFilesButton, finalInfo, userInputField, gridWithRadioButtons, 
				gridWithButtonDespription, renameButton);
	}

	public MenuBar addMenuBar() {		
		menuBar = new MenuBar();
		menuBar.setPrefSize(800.0, 30.0);
		final Menu menuUser = new Menu("User info");
		final Menu menuAbout = new Menu("About");
		final Menu menuExit = new Menu("Exit");
		
		MenuItem menuFileItem1 = new MenuItem("User info");
		menuFileItem1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		        System.out.println("Opening Database Connection...");
		    }
		});		
		
		MenuItem menuFileItem2 = new MenuItem("About");
		menuFileItem2.setOnAction(t -> System.out.println("unavailable"));		
		MenuItem menuFileItem3 = new MenuItem("Exit");
		menuFileItem3.setOnAction(t -> System.exit(0));		
		menuUser.getItems().addAll(menuFileItem1, menuFileItem2, new SeparatorMenuItem(), menuFileItem3);			
				
	//	menuFileItem1.setGraphic(new ImageView(new Image("flower.png")));

		menuBar.getMenus().addAll(menuUser, menuAbout, menuExit);	
		
		return menuBar;
	}
	
	/**
	 * @return the openFileDialog
	 */
	public Button getSearchFilesButton() {
		return selectFilesButton;
	}

	/**
	 * @return the searchBar
	 */
	public TextField getUserInputField() {
		return userInputField;
	}

	/**
	 * @return the renameButton
	 */
	public Button getRenameButton() {
		return renameButton;
	}

	/**
	 * @return the alerts
	 */
	public AlertDialogs getAlerts() {
		return alerts;
	}

	/**
	 * @return the toggleGroup
	 */
	public ToggleGroup getToggleGroup() {
		return toggleGroup;
	}

	/**
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @return the grid
	 */
	public GridPane getGrid() {
		return grid;
	}
	
	
}
