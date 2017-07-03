package steganographie.main;

import java.io.File;

import steganographie.bmpfile.BMPFile;
import steganographie.filetohide.FileReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/24bpp.bmp
//		/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/operation.txt
		
		BMPFile bmpFile = new BMPFile();
		FileReader fileReader = new FileReader();
		
		bmpFile.readBMPFile(new File("/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/24bpp.bmp"));
		
		bmpFile.getBody().hideFileWithinPixelsOfImage(fileReader.readFile(new File("/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/operation.txt")));
		

	}

}
