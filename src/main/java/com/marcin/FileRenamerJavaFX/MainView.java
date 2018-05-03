package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * The main window for the application.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Component
public class MainView {
	private GridPane grid;
	private Button selectFilesButton;
	private Button renameButton;
	private TextField userInputField;
	private Label finalInfo;
	private ToggleGroup toggleGroup;
	@Autowired
	private MenuView menuBarView;
	@Autowired
	private AlertDialogs alerts;
	@Autowired
	private Wallpaper wallpaper;
	@Value("${stage.Title}")
	private String mainStageTitle;
	
	/**
	 * Constructs the MainView.
	 */
	@Autowired                             
	public MainView() {
		this.grid = new GridPane();	
		grid.setPadding(new Insets(0, 0, 20, 0));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPrefSize(800, 600);
	//	grid.setGridLinesVisible(true);
	}

	/**
	 * Constructs the primary Stage and sets the background picture for the main window.
	 * @param primaryStage primary Stage
	 */
	public void initView(Stage primaryStage) {				
		Scene scene = new Scene(grid, 800, 600, Color.RED);
		grid.setBackground(new Background(wallpaper.setWallpaper()));
		primaryStage.setTitle(mainStageTitle);
		primaryStage.setScene(scene);
		primaryStage.show();
		createContent(scene);
	}

	/**
	 * Creates the content of the application main window.
	 * @param scene the container for all content in a scene graph
	 */
	public void createContent(Scene scene) {			
		MenuBar mb = menuBarView.addMenuBar();	
		mb.setPrefSize(800.0, 30.0);
		mb.getMenus().addAll(menuBarView.getMenuUserInfo(), menuBarView.getMenuAbout(), menuBarView.getMenuExit());	
		
		selectFilesButton = new Button("Search for files");
		selectFilesButton.setPrefSize(150, 50);
		selectFilesButton.setDefaultButton(true);
		selectFilesButton.setFont(Font.font("ARIAL", 16.0));
		selectFilesButton.setAlignment(Pos.CENTER);
		
		finalInfo = new Label();
		finalInfo.setPrefSize(400, 90);
		finalInfo.setFont(Font.font("ARIAL", 16));
		finalInfo.setAlignment(Pos.TOP_CENTER);
		String currentYear = LocalDate.now().toString().substring(0, 4);
		finalInfo.setText("Choose the way you want to name your set of files,\n"
				+ "e.g. Summer-" + currentYear + ".\n"
				+ "Choose left or right way of numbering.\n"
				+ "Enjoy your renamed collection of files!"); 
		finalInfo.setTextAlignment(TextAlignment.CENTER);
		
		userInputField = new TextField();
		userInputField.setMaxWidth(400);
		userInputField.setPromptText("Enter your filename schema..");
		userInputField.setPrefColumnCount(15);   // maximum number of characters it can display at one time - doesn't work?
		userInputField.getText();                // the text data entered by a user into the text fields can be obtained by the getText() 
							
		GridPane gridWithRadioButtons = new GridPane();		
		toggleGroup = new ToggleGroup();	
		RadioButton radioButton1 = new RadioButton();
		RadioButton radioButton2 = new RadioButton();
		radioButton1.setPrefWidth(220);
		Label emptyLabelLeft1 = new Label();
		emptyLabelLeft1.setPrefWidth(280);
		gridWithRadioButtons.add(emptyLabelLeft1, 0, 0);
		gridWithRadioButtons.add(radioButton1, 1, 0);
		gridWithRadioButtons.add(radioButton2, 2, 0);
		radioButton1.setUserData(0);
		radioButton2.setUserData(1);
		radioButton1.setToggleGroup(toggleGroup);
		radioButton2.setToggleGroup(toggleGroup);
		radioButton1.setVisible(true);
		radioButton2.setVisible(true);  
		toggleGroup.selectToggle(radioButton1);
        
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
			    	
		GridPane.setConstraints(mb, 0, 0);
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
		
		
		grid.getChildren().addAll(mb, selectFilesButton, finalInfo, userInputField, gridWithRadioButtons, 
				gridWithButtonDespription, renameButton);
	}

	/**
	 * Adding menu bar.
	 * @return the menu bar for application main window
	 */
	public MenuBar addMenuBar() {		
		MenuBar menuBar = new MenuBar();
		menuBar.setPrefSize(800.0, 30.0);
		final Menu menuUser = new Menu("User info");
		final Menu menuAbout = new Menu("About");
		final Menu menuExit = new Menu("Exit");
		
		MenuItem menuUserInfo = new MenuItem("User info");
		menuUserInfo.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setX(StartApp.getPrimaryStage().getX() + 200);
				alert.setY(StartApp.getPrimaryStage().getY() + 200);
		        alert.setTitle("---User info---");	 
		        alert.setHeaderText(null);
		        alert.setContentText("SUCCESS!");	 
		        alert.showAndWait();
		    }
		});		
		
		MenuItem menuUserAbout = new MenuItem("About");
		menuUserAbout.setOnAction(t -> System.out.println("unavailable"));		
		MenuItem menuUserExit = new MenuItem("Exit");
		menuUserExit.setOnAction(t -> System.exit(0));		
		menuUser.getItems().addAll(menuUserInfo, menuUserAbout, new SeparatorMenuItem(), menuUserExit);			
				

		menuBar.getMenus().addAll(menuUser, menuAbout, menuExit);	
		
		return menuBar;
	}
	
	/**
	 * @return the searchFilesButton
	 */
	public Button getSearchFilesButton() {
		return selectFilesButton;
	}

	/**
	 * @return the userInputField
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
	public MenuView getMenuBarView() {
		return menuBarView;
	}

	/**
	 * @return the grid
	 */
	public GridPane getGrid() {
		return grid;
	}
}
