package steganographie.filetohide;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

	private byte[] pairOfBits;
	private long fileToHideSize;
	private String fileExtension; 
	private Path filePath; //hecho para usarlo en el método q crea el array con la info (hace falta partir del fichero??)
	
	/**
	 * getter
	 * @return pairOfBits
	 */
	public byte[] getPairOfBits() {
		return pairOfBits;
	}

	/**
	 * setter
	 * @param pairOfBits
	 */
	public void setPairOfBits(byte[] pairOfBits) {
		this.pairOfBits = pairOfBits;
	}

	/**
	 * getter
	 * @return fileToHideSize
	 */
	public long getFileToHideSize() {
		return fileToHideSize;
	}

	/**
	 * setter
	 * @param fileToHideSize
	 */
	public void setFileToHideSize(long fileToHideSize) {
		this.fileToHideSize = fileToHideSize;
	}

	
	/**
	 * getter
	 * @return fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * setter
	 * @param fileExtension
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}


	/** 
	 * get the required information to file recovery and reconstruction 
	 * @param file
	 * @return
	 */
	public byte[] getFileInformationToReconstruction(File file) {
	
		this.fileToHideSize = file.length();
		
		try {
			this.fileExtension = Files.probeContentType(this.filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] informationSize = new byte[8];
		ByteBuffer buf = ByteBuffer.wrap(informationSize);
		buf.putLong(fileToHideSize);
		
		byte[] informationExtension = fileExtension.getBytes(); //es posible fijar tamaño máximo?
		
		byte[] information = new byte[(8+informationExtension.length)];
		
		System.arraycopy(informationSize, 0, information, 0, 8);
		System.arraycopy(informationExtension, 0, information, 8, informationExtension.length);
		
		
		return information;
	}
	
	
	/**
	 * read a file and get an array with his bytes 
	 * @param file
	 * @return
	 */
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

	/**
	 * concatenate the byte array with the information of the file and the byte array with the stored bytes from the file and get the array to hide in the image 
	 * @param information
	 * @param fileByteArray
	 * @return
	 */
	public byte[] concatenateInformationReadArrays(byte[] information, byte[] fileByteArray) {
		int informationLength = information.length;
		int fileByteArrayLength = fileByteArray.length;
		
		byte[] fileToHideArray = new byte[informationLength + fileByteArrayLength];
		System.arraycopy(information, 0, fileToHideArray, 0, informationLength);
		System.arraycopy(fileByteArray, 0, fileToHideArray, informationLength, fileByteArrayLength);

		return fileToHideArray;
		
	}
	
	/**
	 * get a byte array dividing each byte from another array into four pairs of bits 
	 * @param b
	 * @return
	 */
	public byte[] getPairOfBitsFromByteArray(byte[] b) {
		byte[] pairOfBits = new byte[(4*b.length)];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < 4; j+=4) {
				pairOfBits[j] = (byte) (b[i]%4);
				pairOfBits[j+1] = (byte) ((b[i]/4)%4);
				pairOfBits[j+2] = (byte) ((b[i]/16)%4);
				pairOfBits[j+3] = (byte) (b[i]/64);	
			}
		}
		return pairOfBits;
	}

}
