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
		menuItemInfo = new MenuItem("Read me");
		menuItemExit = new MenuItem("Exit");
		
		menuAbout = new Menu("About");
		menuItemAbout = new MenuItem("About");
		
		menuExit = new Menu("Exit");
		menuItemExitExit = new MenuItem("Exit");
		
		menuUserInfo.getItems().addAll(menuItemInfo, new SeparatorMenuItem(), menuItemExit);	
		menuAbout.getItems().addAll(menuItemAbout);
		menuExit.getItems().addAll(menuItemExitExit);
		
		menuBar.setPrefSize(800.0, 30.0);
		menuBar.getMenus().addAll(menuUserInfo, menuAbout, menuExit);	
		
		return menuBar;
	}
	
	/**
	 * Shows the basic information about the application rules.
	 */
	public void userInfoAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Content here", ButtonType.OK);
		alert.getDialogPane().setPrefSize(750, 420);
		alert.setX(StartApp.getPrimaryStage().getX() + 25);
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
		alert.getDialogPane().setPrefSize(450, 170);
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

	/**
	 * @return the menuItemExitExit
	 */
	public MenuItem getMenuItemExitExit() {
		return menuItemExitExit;
	}
}
