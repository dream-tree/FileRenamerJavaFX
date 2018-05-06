package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcin.FileRenamerJavaFX.repository.FileLoader;
import com.marcin.FileRenamerJavaFX.repository.FileLoaderImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRenamerJavaFxApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Bean(name="fileLoaderImplTest")
	public FileLoader loadFiles() {		
		List<File> filesList = new ArrayList<>();
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\lenny.jpg"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\abcdef.txt"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\012-kop.jpg"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\_VOX_.png"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\sampl.e"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\noExtension"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\.noFilename"));
		filesList.add(new File("c:\\RootFolder\\PictureFolder\\more.dots.pdf"));
		return new FileLoaderImpl();
	}
	
}
