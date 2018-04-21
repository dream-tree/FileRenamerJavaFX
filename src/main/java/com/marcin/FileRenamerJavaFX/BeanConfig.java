package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig {
	
	@Bean(name="backgroundPic")
	public Wallpaper setBackgroundImage() {
		return new Wallpaper();
	}
	
	@Bean(name="alerts")
	public AlertDialogs setAlertDialogs() {
		return new AlertDialogs();
	}
	
	@Bean(name="mainView")
	public MainView createMainView() {
		return new MainView();
	}
	
	@Bean(name="fileLoaderImplArrayList")
	public FileLoaderImpl loadFiles() {
		return new FileLoaderImpl(createMainView(), new ArrayList<File>());
	}
	
	/*	Unnecessary because it is not possible to inject the same instance of Stage to other objects.
 		JavaFX uses Stage instance as internal mandatory object, I can't reference it.
	 	@Bean(name="primaryStage")
		public Stage setPrimaryStage() {
			return new Stage();
		}
	*/
}
