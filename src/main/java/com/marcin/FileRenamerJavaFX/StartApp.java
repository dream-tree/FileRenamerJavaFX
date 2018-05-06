package com.marcin.FileRenamerJavaFX;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marcin.FileRenamerJavaFX.controllers.MainViewController;
import com.marcin.FileRenamerJavaFX.controllers.MenuController;
import com.marcin.FileRenamerJavaFX.controllers.ToggleController;
import com.marcin.FileRenamerJavaFX.data.BeanConfig;
import com.marcin.FileRenamerJavaFX.views.MainView;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point of the FileRenamerJavaFX application.
 * It initializes the JavaFX platform start() method
 * and constructs the primary and the only Stage for the application.
 * This class also initializes Spring container 
 * and loads the beans necessary for the dependency injection.
 * 
 * This project uses "plain" Java code for GUI building (for exercising purposes). JavaFX Scene Builder haven't been used.
 * Project uses some basic Spring Framework features.
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
			MenuController menuControllers = context.getBean(MenuController.class);
			menuControllers.initMenuController();
			context.close();
			
			Logger logger = LoggerFactory.getLogger(StartApp.class);
			logger.info("hello");
			
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
