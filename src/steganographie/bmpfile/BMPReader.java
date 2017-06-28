package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	 * read a bmp image file and 
	 * @param file
	 */
	public static void readBMPFile(File file) {
		//int contador = 0;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(fis);
			
			ImageFileHeader imageFileHeader = new ImageFileHeader();
			ImageBMPHeader imageBMPHeader = new ImageBMPHeader();
			ImageBody imageBody = new ImageBody();
			
			imageFileHeader.setHeaderField(imageFileHeader.readPartOfFile(buffer, 2));
			imageFileHeader.setFileSize(imageFileHeader.readPartOfFile(buffer, 4));
			imageFileHeader.setReservedField(imageFileHeader.readPartOfFile(buffer, 4));
			imageFileHeader.setOffset(imageFileHeader.readPartOfFile(buffer, 4));

			imageBMPHeader.setHeaderSize(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setImageWidth(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setImageHeight(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setColorPlanes(imageBMPHeader.readPartOfFile(buffer, 2));
			imageBMPHeader.setColorDepth(imageBMPHeader.readPartOfFile(buffer, 2));
			imageBMPHeader.setCompressionMethod(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setImageSize(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setHorizontalResolution(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setVerticalResolution(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setPaletteColors(imageBMPHeader.readPartOfFile(buffer, 4));
			imageBMPHeader.setImportantColors(imageBMPHeader.readPartOfFile(buffer, 4));
			
			buffer.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main (String[] args) {
		//readBMPFile(new File("src/Col5NPsSiSO300_m007.bmp"));
		
	}



	

}
