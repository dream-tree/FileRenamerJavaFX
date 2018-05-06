package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Menu controllers for the application main view.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Controller
public class MenuController {
	
	private MenuView menuView;
	
	@Autowired
	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}
	
	/**
	* Initializes menu controller for the application main view.
	*/
	public void initMenuController() {		
		menuView.getMenuItemInfo().setOnAction(t -> menuView.userInfoAlert());		
		menuView.getMenuItemExit().setOnAction(t -> System.exit(0));		
		menuView.getMenuItemAbout().setOnAction(t -> menuView.userAboutAlert());		
		menuView.getMenuItemExitExit().setOnAction(t -> System.exit(0));						
	}	
}
