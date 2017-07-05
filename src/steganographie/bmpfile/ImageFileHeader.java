package steganographie.bmpfile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageFileHeader extends BMPFileFraction {
	
	private byte[] headerField = new byte[2]; //to identify BMP file
	private byte[] fileSize = new byte[4]; // size of the BMP file in bytes
	private byte[] reservedField = new byte[4]; // actual value depends on the application that creates the image 
	private byte[] offset = new byte[4]; // starting address of the byte where the bitmap image data (pixel array) can be found.
	


	/**
	 * getter
	 * @return headerField
	 */
	public byte[] getHeaderField() {
		return this.headerField;
	}
	
	/**
	 * getter
	 * @param bis
	 * @return headerField
	 */
	public byte[] getHeaderField(BufferedInputStream bis) {
		return readPartOfFile(bis, 2);
	}
	
	
	/**
	 * setter
	 * @param headerField
	 */
	public void setHeaderField(byte[] headerField) {
		this.headerField = headerField;
	}

	
	/**
	 * getter
	 * @return fileSize
	 */
	public byte[] getFileSize() {
		return this.fileSize;
	}

	
	/**
	 * getter
	 * @param bis
	 * @return fileSize
	 */
	public byte[] getFileSize(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
	}
	
	
	/**
	 * setter
	 * @param fileSize
	 */
	public void setFileSize(byte[] fileSize) {
		this.fileSize = fileSize;
	}


	/**
	 * getter
	 * @return reservedField
	 */
	public byte[] getReservedField() {
		return this.reservedField;
	}
	
	/**
	 * getter
	 * @param bis
	 * @return reservedField
	 */
	public byte[] getReservedField(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
	}
	
	
	/**
	 * setter
	 * @param reservedField
	 */
	public void setReservedField(byte[] reservedField) {
		this.reservedField = reservedField;
	}


	/**
	 * getter
	 * @return offset
	 */
	public byte[] getOffset() {
		return this.offset;
	}

	
	/**
	 * getter
	 * @param bis
	 * @return offset
	 */
	public byte[] getOffset(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
	}
	
	/**
	 * setter
	 * @param offset
	 */
	public void setOffset(byte[] offset) {
		this.offset = offset;
	}

	/**
	 * get the file type from the byte array headerFile
	 * @param headerFile
	 * @return
	 */
	public String getType (byte[] headerFile) {
		String str = new String(headerFile);
		return str;	
	}
	
	/**
	 * get the size of the file from the byte array fileSize
	 * @param fileSize
	 * @return
	 */
	public int getSize (byte[] fileSize) {
		int size = byteArrayToInt(fileSize);
		return size;
	}
	
	
	/**
	 * get the value of the reservedField
	 * @param offset
	 * @return
	 */
	
	
	
	/**
	 * get the starting address of the byte where the bitmap image data (pixel array) can be found
	 * @param offset
	 * @return
	 */
	public int getByteOffset (byte[] offset) {
		int imageStartingByte = byteArrayToInt (offset);
		return imageStartingByte;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
}
