package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

/**
 * Controller for the toggle buttons.
 * Toggles are responsible for renaming options chosen by user i.e,
 * left or right file numbering in the renaming process.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Controller
public class ToggleController {

	private MainView mainView;
	private DataModel model;
	
	/**
	* Constructs the ToggleController.
	* @param mainView the MainView instance
	* @param model the DataModel instance
	*/
	@Autowired
	public ToggleController(MainView mainView, DataModel model) {
		this.mainView = mainView;
		this.model = model;
	}
	
	/**
	 * Initializes the toggle controller to enable the choice of the file numbering option. 
	 * The position array below contains one of two possible options: left or right hand side file numbering schema chosen by user:
	 *  0 stands for numbering files from the left (default),
	 *  1 stands for numbering files from the right.
	 */
	public void initToggleController() {
		int[] position = new int[1];
		mainView.getToggleGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		            if(mainView.getToggleGroup().getSelectedToggle() != null) {
		            	final int obt = position[0] = (int) mainView.getToggleGroup().getSelectedToggle().getUserData();
		            	if(position[0] == 0) {
		            		model.setRenamingOption(0);
		            	} else {
		            		model.setRenamingOption(1);
		            	}
		            }
		        }
		});
	}
}
