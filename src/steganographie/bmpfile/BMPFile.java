package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPFile {
	
	private ImageFileHeader fileHeader; 
	private ImageBMPHeader bmpHeader; 
	private ImageBody body; 
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
	public void readBMPFile(File file) {
		//int contador = 0;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(fis);
			
			this.fileHeader.setHeaderField(this.fileHeader.getHeaderField(buffer));
			this.fileHeader.setFileSize(this.fileHeader.getFileSize(buffer));
			this.fileHeader.setReservedField(this.fileHeader.getReservedField(buffer));
			this.fileHeader.setOffset(this.fileHeader.getOffset(buffer));

			this.bmpHeader.setHeaderSize(this.bmpHeader.getHeaderSize(buffer));
			this.bmpHeader.setImageWidth(this.bmpHeader.getImageHeight(buffer));
			this.bmpHeader.setImageHeight(this.bmpHeader.getImageHeight(buffer));
			this.bmpHeader.setColorPlanes(this.bmpHeader.getColorPlanes(buffer));
			this.bmpHeader.setColorDepth(this.bmpHeader.getColorDepth(buffer));
			this.bmpHeader.setCompressionMethod(this.bmpHeader.getCompressionMethod(buffer));
			this.bmpHeader.setImageSize(this.bmpHeader.getImageSize(buffer));
			this.bmpHeader.setHorizontalResolution(this.bmpHeader.getHorizontalResolution(buffer));
			this.bmpHeader.setVerticalResolution(this.bmpHeader.getVerticalResolution(buffer));
			this.bmpHeader.setPaletteColors(this.bmpHeader.getPaletteColors(buffer));
			this.bmpHeader.setImportantColors(this.bmpHeader.getImportantColors(buffer));
			
			//this.body.setImage(this.body.getImage(buffer));
			
			buffer.close();
			fis.close();
			
			//mientras hago funcionar la linea anterior
			BufferedImage img = ImageIO.read(file);			
			body.setImage(body.getImage(img));
			
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
