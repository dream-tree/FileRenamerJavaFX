package com.marcin.FileRenamerJavaFX.views;

import org.springframework.stereotype.Component;

import com.marcin.FileRenamerJavaFX.StartApp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
        /*
         * "No file was renamed" might not always be true: 
         * if an error occurs during the renaming process and part of the files is renamed and part is not, this statement lies.
         * By now, application doesn't provide a way to automatically bring back the previous file names 
         * for partly renamed set of files (what is of course possible).
         * But: this situation may happen only if some unpredicted circumstances occur during the renaming process. 
         * This error should be announced by RenamingException handler.
         */
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
		alert.setContentText("Filename length exceeded.\n"
        		+ "Maximum length without numbering is 251.\n"
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
