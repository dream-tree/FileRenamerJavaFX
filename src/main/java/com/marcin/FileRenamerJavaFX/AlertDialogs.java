package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Alert types for whole application.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Component
public class AlertDialogs {
	
	/**
	 * Constructs the AlertDialogs for all events in the application life-cycle.
	 */
	@Autowired
	public AlertDialogs() {
	}
	
	/**
	 * Notifies user about lack of input in the text field.
	 */
	public void noUserInputAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't typed anything!");	 
        alert.showAndWait();
	}
	
	/**
	 * Notifies user about not selecting any file by user.
	 */
	public void noFileSelectedAlertDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("ALERT: something went wrong..");	 
        alert.setHeaderText(null);
        alert.setContentText("You haven't selected any file!");	 
        alert.showAndWait();
	}
	
	/**
	 * Notifies user about error in the renaming process (unsupported character).
	 */
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
	
	/**
	 * Notifies user about exceeding the file name length.
	 */
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
	
	/**
	 * Notifies user about the number of successfully renamed files.
	 */
	public void renamingSuccessAlertDialog(int numberOfRenamedFiles) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("Success in renaming files.");	 
        alert.setHeaderText(null);
        alert.setContentText(numberOfRenamedFiles==1 ? numberOfRenamedFiles + " file successfully renamed!" 
        						: numberOfRenamedFiles + " files successfully renamed!");	 
        alert.showAndWait();
	}	
}
