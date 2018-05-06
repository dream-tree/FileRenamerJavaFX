package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

/**
 * Class responsible for loading files chosen by user.
 * Files are selected using FileChoser dialog.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Repository
public class FileLoaderImpl implements FileLoader {
	
	private List<File> filesList;
	
	/** 
	 * Constructs the FileLoaderImpl.
	 */
	public FileLoaderImpl() {			
	}
		
	/**
	 * {@inheritDoc}
	 */
	public void loadFiles() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selecting files..");
		// initializing list of files or clearing list if user takes another action in the same session
		filesList = fileChooser.showOpenMultipleDialog(StartApp.getPrimaryStage());
	}

	/**
	 * {@inheritDoc}
	 */
	public List<File> getFilesList() {
		return filesList;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateFilesList(List<File> filesList) {
		this.filesList = filesList;
	}
}
