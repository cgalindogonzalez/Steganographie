package steganographie.filetohide;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	 * get the required information to subsequent file recovery and reconstruction 
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
		
		byte[] informationExtension = new byte[8];
		informationExtension = fileExtension.getBytes(); //es posible fijar tamaño máximo?
		
		byte[] information = new byte[(8+informationExtension.length)]; //16??
		
		System.arraycopy(informationSize, 0, information, 0, 8);
		System.arraycopy(informationExtension, 0, information, 8, informationExtension.length); //cambiar por 8?
		
		
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
	
	/**
	 * get an array of bytes made up using four pairs of bits 
	 * @param b
	 * @return
	 */
	public byte[] getByteArrayFromPairOfBits (byte[] b) {
		byte[] byteArray = new byte[(b.length)/4];
		
		for (int i = 0; i < b.length; i+=4 ) {
			int b4 = b[i];
			int b3 = b[i+1];
			int b2 = b[i+2];
			int b1 = b[i+3];
			for (int j = 0; j< byteArray.length; j++) {
				byteArray[j] = (byte) (b4 + b3*4 + b2*16 + b1*64);
			}
		}
		
		return byteArray;	
	}
	
	/**
	 * get the size of the file from the first eight bytes of the recovered array
	 * @param b
	 * @return
	 */
	public long getFileSizeFromRecoveredArray(byte[] b) {
		byte[] sizeFileArray = new byte[8];
		System.arraycopy(b, 0, sizeFileArray, 0, 8);
		
		long size = ByteBuffer.wrap(sizeFileArray).getLong();
		return size;
	}
	
	/**
	 * get the extension of the file from the next ¿eight? bytes of the recovered array
	 * @param b
	 * @return
	 */
	public String getFileExtensionFromRecoveredArray (byte[] b) {
		byte[] extensionFileArray = new byte[8]; // Es 8????
		String str = new String (extensionFileArray);
		
		return str;
	}
	
	/**
	 * get the byte array with bytes of the file from the recovered array (that can be longer)
	 * @param b
	 * @param size
	 * @return
	 */
	public byte[] getFileArrayFromRecoveredArray (byte[] b, long size) {
		int length = (int) size;
		byte[] fileArray = new byte[length];
		System.arraycopy(b, 16, fileArray, 0, length);
				
		return fileArray;
	}

	/**
	 * recover the file and save it with the name recovered_file into the folder where the image is
	 * @param fileArray
	 * @param pathFile
	 * @param extension
	 */
	public void saveFile (byte[] fileArray, String pathFile, String extension) {
		
		String str = pathFile + System.getProperty("File.separator") + "recovered_file." + extension;
		File file = new File(str);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(fileArray);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
