package com.marcin.FileRenamerJavaFX;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point of the application.
 * It initializes the JavaFX platform start() method
 * and constructs the primary and the only Stage for the application.
 * This class also initializes Spring container 
 * and loads the beans necessary for the dependency injection.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
public class StartApp extends Application {
		
	/**
	 * The primary Stage used in subsequent classes in the application.
	 */
	private static Stage primaryStage;
	
	public void start(Stage primaryStage) {
		StartApp.primaryStage = primaryStage;
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
			MainView view = context.getBean(MainView.class);		
			view.initView(primaryStage);	
			MainViewController mainController = context.getBean(MainViewController.class);
			mainController.initMainController();	
			ToggleController toggleController = context.getBean(ToggleController.class);
			toggleController.initToggleController();
			MenuControllers menuControllers = context.getBean(MenuControllers.class);
			menuControllers.initMenuController();
			context.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the primaryStage
	 */
	public static Stage getPrimaryStage() {
		return StartApp.primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
