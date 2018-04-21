package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;

@Controller
public interface FileLoader {

	public void loadFiles();
	//TODO default?
	public List<File> getFilesList();
	public void setFilesList(List<File> filesList);
}
