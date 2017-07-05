package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPFileReader {
	
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
	 * read a bmp image file and divide it into his parts (file header, bmp header and body)
	 * @param file
	 */
	public void readBMPFile(File file) {

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
	

	public void rebuildAndSaveBMPImage(String name) {
		String str = this.getPathDir() + System.getProperty("file.separator") + name + ".bmp";
		File file = new File(str);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte [] headerFieldOfFileHeader = this.getFileHeader().getHeaderField();
			bos.write(headerFieldOfFileHeader);
			
			byte [] fileSizeOfFileHeader = this.getFileHeader().getFileSize();
			bos.write(fileSizeOfFileHeader);
			
			byte [] reservedFieldOfFileHeader = this.getFileHeader().getReservedField();
			bos.write(reservedFieldOfFileHeader);
			
			byte [] offsetOfFileHeader = this.getFileHeader().getOffset();
			bos.write(offsetOfFileHeader);
			
			byte [] headerSizeOfBMPHeader = this.getBmpHeader().getHeaderSize();
			bos.write(headerSizeOfBMPHeader);
			
			byte [] imageWidthOfBMPHeader = this.getBmpHeader().getImageWidth();
			bos.write(imageWidthOfBMPHeader);
			
			byte [] imageHeightOfBMPHeader = this.getBmpHeader().getImageHeight();
			bos.write(imageHeightOfBMPHeader);
			
			byte [] colorPlanesOfBMPHeader = this.getBmpHeader().getColorPlanes();
			bos.write(colorPlanesOfBMPHeader);
			
			byte [] colorDepthOfBMPHeader = this.getBmpHeader().getColorDepth();
			bos.write(colorDepthOfBMPHeader);
			
			byte [] compressionMethodOfBMPHeader = this.getBmpHeader().getCompressionMethod();
			bos.write(compressionMethodOfBMPHeader);
			
			byte [] imageSizeOfBMPHeader = this.getBmpHeader().getImageSize();
			bos.write(imageSizeOfBMPHeader);
			
			byte [] horizontalResolutionOfBMPHeader = this.getBmpHeader().getHorizontalResolution();
			bos.write(horizontalResolutionOfBMPHeader);

			byte [] verticalResolutionOfBMPHeader = this.getBmpHeader().getVerticalResolution();
			bos.write(verticalResolutionOfBMPHeader);
			
			byte [] paletteColorsOfBMPHeader = this.getBmpHeader().getPaletteColors();
			bos.write(paletteColorsOfBMPHeader);
			
			byte [] importantColorsOfBMPHeader = this.getBmpHeader().getImportantColors();
			bos.write(importantColorsOfBMPHeader);
			
			//Cuando cambie el bufferedImage por el byte[] estará bien
//			byte [] imageBodyWithHiddenFile = this.getBody();
//			bos.write(imageBodyWithHiddenFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main (String[] args) {

		
	}



	

}
