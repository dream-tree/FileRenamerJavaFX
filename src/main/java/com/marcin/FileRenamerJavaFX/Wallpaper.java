package com.marcin.FileRenamerJavaFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;


public class Wallpaper {
		
	@Autowired
	public Wallpaper() {
	}

	public BackgroundImage setWallpaper() {
		Path path = FileSystems.getDefault().getPath("src/main/java/com/marcin/FileRenamerJavaFX/wallpaper3d.jpg");			
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
