package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:info.properties")
public class BeanConfig {
	
/*	@Bean(name="backgroundPic")
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
	public FileLoader loadFiles() {
		return new FileLoaderImpl();
	}*/

}
