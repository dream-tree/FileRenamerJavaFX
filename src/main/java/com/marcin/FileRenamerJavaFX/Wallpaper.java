package com.marcin.FileRenamerJavaFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

/**
 * Initialization of background picture for the application main window.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Component
public class Wallpaper {
	
	/**
	* Constructs the Wallpaper.
	*/
	@Autowired
	public Wallpaper() {
	}
	
	/**
	 * Loads background picture (wallpaper) for the main window.
	 * @return BackgroundImage object to be set as Background in the main window
	 */
	public BackgroundImage setWallpaper() {
		Path path = FileSystems.getDefault().getPath("src/main/resources/wallpaper3e.jpg");			
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(path.toString());
		} catch (FileNotFoundException e) {
			// TODO: logger
			e.printStackTrace();
		} 
		Image image = new Image(inputstream);
		BackgroundImage backgroundImage = new BackgroundImage(image,
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		return backgroundImage;
	}
}
