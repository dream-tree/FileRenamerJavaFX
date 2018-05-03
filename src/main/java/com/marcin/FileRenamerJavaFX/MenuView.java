package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Region;

/**
 * Class creates menu bar for the application main view.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Component
public class MenuView {
	
	private MenuBar menuBar;
	private Menu menuUserInfo;
	private MenuItem menuItemInfo;
	private MenuItem menuItemExit;
	private Menu menuAbout;
	private MenuItem menuItemAbout;
	private Menu menuExit;
	private MenuItem menuItemExitExit;
		
	@Value("${menuView.userInfo}")
	private String userInfo;
	
	@Value("${menuView.aboutInfo}")
	private String aboutInfo;
	
	/**
	* Constructs the MenuView.
	*/
	public MenuView() {
	}
	
	/**
	 * Creates MenuBar for the application main view..
	 */
	public MenuBar addMenuBar() {
		menuBar = new MenuBar();

		menuUserInfo = new Menu("User info");
		menuItemInfo = new MenuItem("Info");
		menuItemExit = new MenuItem("Exit");
		
		menuAbout = new Menu("About");
		menuItemAbout = new MenuItem("About");
		
		menuExit = new Menu("Exit");
		menuItemExitExit = new MenuItem("Exit");
		
		menuUserInfo.getItems().addAll(menuItemInfo, new SeparatorMenuItem(), menuExit);	
		menuAbout.getItems().addAll(menuItemAbout);
		menuExit.getItems().addAll(menuItemExitExit);
		
		return new MenuBar();
	}
	
	/**
	 * Shows the basic information about the application rules.
	 */
	public void userInfoAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Content here", ButtonType.OK);
		alert.getDialogPane().setPrefSize(550, 320);
	//	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setX(StartApp.getPrimaryStage().getX() + 125);
		alert.setY(StartApp.getPrimaryStage().getY() + 100);
        alert.setTitle("---User info---");	 
        alert.setHeaderText(null);
        alert.setContentText(userInfo);	 
        alert.showAndWait();
	}

	/**
	 * Shows information about the author of the application.
	 */
	public void userAboutAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setX(StartApp.getPrimaryStage().getX() + 200);
		alert.setY(StartApp.getPrimaryStage().getY() + 200);
        alert.setTitle("---About---");	 
        alert.setHeaderText(null);
        alert.setContentText(aboutInfo);	 
        alert.showAndWait();
	}
	
	/**
	 * @return the menuUserInfo
	 */
	public Menu getMenuUserInfo() {
		return menuUserInfo;
	}

	/**
	 * @return the menuItemInfo
	 */
	public MenuItem getMenuItemInfo() {
		return menuItemInfo;
	}

	/**
	 * @return the menuItemExit
	 */
	public MenuItem getMenuItemExit() {
		return menuItemExit;
	}

	/**
	 * @return the menuAbout
	 */
	public Menu getMenuAbout() {
		return menuAbout;
	}

	/**
	 * @return the menuExit
	 */
	public Menu getMenuExit() {
		return menuExit;
	}

	/**
	 * @return the menuItemAbout
	 */
	public MenuItem getMenuItemAbout() {
		return menuItemAbout;
	}	
	
	/**
	 * @return the menuExit
	 */
	public Menu getMenuExitExit() {
		return menuExit;
	}
}
