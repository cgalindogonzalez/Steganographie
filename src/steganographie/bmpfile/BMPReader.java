package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPReader {
	
	private ImageFileHeader fileHeader; // 14 primeros bits
	private ImageBMPHeader bmpHeader; // 50 siguientes
	private ImageBody body; // el resto
	private String pathDir;
	private String fileName;
	

	/**
	 * getter
	 * @return fileHeader
	 */
	public ImageFileHeader getFileHeader() {
		return this.fileHeader;
	}
	

	/**
	 * setter
	 * @param fileHeader
	 */
	public void setFileHeader(ImageFileHeader fileHeader) {
		this.fileHeader = fileHeader;
	}

	/**
	 * getter
	 * @return bmpHeader
	 */
	public ImageBMPHeader getBmpHeader() {
		return this.bmpHeader;
	}


	/**
	 * setter
	 * @param bmpHeader
	 */
	public void setBmpHeader(ImageBMPHeader bmpHeader) {
		this.bmpHeader = bmpHeader;
	}
	
	
	/**
	 * getter
	 * @return body
	 */
	public ImageBody getBody() {
		return this.body;
	}


	/**
	 * setter
	 * @param body
	 */
	public void setBody(ImageBody body) {
		this.body = body;
	}
	
	/**
	 * getter
	 * @return pathDir
	 */
	public String getPathDir() {
		return this.pathDir;
	}


	/**
	 * setter
	 * @param pathDir
	 */
	public void setPathDir(String pathDir) {
		this.pathDir = pathDir;
	}


	/**
	 * getter
	 * @return fileName
	 */
	public String getFileName() {
		return this.fileName;
	}


	/**
	 * setter
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * read a bmp image file and....
	 * @param file
	 */
	public void readBMPFile(File file) {
		try {
			BufferedImage img = ImageIO.read(file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	

}
