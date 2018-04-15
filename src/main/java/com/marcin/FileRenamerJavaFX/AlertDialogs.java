package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AlertDialogs {
	
	@Autowired
	public AlertDialogs() {
	}
	
	public void noUserInputAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT!");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't typed anything!");	 
        alert.showAndWait();

	}
	
	public void noFileSelectedAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT!");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't selected any file!");	 
        alert.showAndWait();

	}
}
