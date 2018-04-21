package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

@Controller
public class ToggleController {

	private MainView mainView;
	private DataModel model;
	
	public ToggleController(MainView mainView, DataModel model) {
		this.mainView = mainView;
		this.model = model;
	}
	
	public void initToggleController() {
		mainView.getToggleGroup().selectToggle(null);
		int[] position = new int[1];
		mainView.getToggleGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		    public void changed(ObservableValue<? extends Toggle> ov,Toggle old_toggle, Toggle new_toggle) {
		            if(mainView.getToggleGroup().getSelectedToggle() != null) {
		            	final int obt = position[0] = (int) mainView.getToggleGroup().getSelectedToggle().getUserData();
		            	if(position[0] == 0) {
		            		model.setOptionFlag(0);
		            	} else {
		            		model.setOptionFlag(1);
		            	}
		            	System.out.println(obt);
		            }                
		        }
		});
	}
}
