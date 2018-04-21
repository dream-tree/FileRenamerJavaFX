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
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't typed anything!");	 
        alert.showAndWait();

	}
	
	public void noFileSelectedAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't selected any file!");	 
        alert.showAndWait();
	}
	
	public void renamingErrorAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("Invalid character, e.g. : or ?\n"
        		+ "No file was renamed.");	 
        alert.showAndWait();
	}
	
	public void excededInputLengthAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("Exceeded length of your filename.\n"
        		+ "Maximum length without numbering is 250.\n"
        		+ "No file was renamed.");	 
        alert.showAndWait();
	}	
}
