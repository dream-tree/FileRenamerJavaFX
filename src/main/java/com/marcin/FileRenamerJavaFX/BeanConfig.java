package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javafx.stage.Stage;

@Configuration
@ComponentScan
public class BeanConfig {

/*	Unnecessary because it is not possible to inject the same instance of Stage to other objects.
 *  JavaFX uses Stage this instance as internal mandatory object, I can't reference it.
 	@Bean(name="primaryStage")
	public Stage setPrimaryStage() {
		return new Stage();
	}*/
	
	@Bean(name="alerts")
	public AlertDialogs setAlertDialogs() {
		return new AlertDialogs();
	}
	
	@Bean(name="mainView")
	public MainView createMainView() {
		return new MainView(setAlertDialogs());
	}
	
	@Bean(name="fileLoaderImplArrayList")
	public FileLoaderImpl loadFiles() {
		return new FileLoaderImpl(createMainView(), new ArrayList<File>());
	}
	

}
