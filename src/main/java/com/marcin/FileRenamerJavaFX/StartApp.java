package com.marcin.FileRenamerJavaFX;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point of the FileRenamerJavaFX application.
 * It initializes the JavaFX platform start() method
 * and constructs the primary and the only Stage for the application.
 * This class also initializes Spring container 
 * and loads the beans necessary for the dependency injection.
 * 
 * Project uses "plain" Java code for GUI, JavaFX Scene Builder
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@SpringBootApplication
public class StartApp extends Application {
		
	/**
	 * The primary Stage used in subsequent classes in the application.
	 */
	private static Stage primaryStage;
	
    @Override
    public void init()
    {
    	SpringApplication.run(StartApp.class);
    }
	
	public void start(Stage primaryStage) {
		StartApp.primaryStage = primaryStage;
/*		try {
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
			
			Logger logger = LoggerFactory.getLogger(StartApp.class);
			logger.info("hello");
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
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
