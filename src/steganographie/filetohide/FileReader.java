package steganographie.filetohide;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
	
	private byte[] pairOfBits;
	
	public byte[] readFile(File file) {
		
		//init array with file length
		 byte[] fileByteArray = new byte[(int) file.length()];
		 
		try {
			FileInputStream	fis = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(fis);
			buffer.read(fileByteArray); //read file into bytes[]
			buffer.close();
			fis.close(); 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileByteArray;
	}
	
	private byte[] getPairOfBitsFromByteArray(byte[] b) {
		
		
		return null;
	}

}
