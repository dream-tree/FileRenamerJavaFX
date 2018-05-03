package com.marcin.FileRenamerJavaFX;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Menu controllers for the application main view.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Component
public class MenuControllers {
	
	private MenuView menuView;
	
	public MenuControllers(MenuView menuView) {
		this.menuView = menuView;
	}
	
	/**
	* Initializes menu controller for the application main view.
	*/
	public void initMenuController() {		
		menuView.getMenuItemInfo().setOnAction(t -> menuView.userInfoAlert());		
		menuView.getMenuItemExit().setOnAction(t -> System.exit(0));		
		menuView.getMenuItemAbout().setOnAction(t -> menuView.userAboutAlert());		
		menuView.getMenuItemExit().setOnAction(t -> System.exit(0));						
	}	
}
