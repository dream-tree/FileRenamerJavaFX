package com.marcin.FileRenamerJavaFX.repository;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.marcin.FileRenamerJavaFX.StartApp;

import javafx.stage.FileChooser;

/**
 * Class responsible for loading files chosen by user.
 * Files are selected using the FileChooser dialog.
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
