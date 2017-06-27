package steganographie.bmpfile;

public class ImageFileHeader {
	
	private byte[] headerField = new byte[2]; //to identify BMP file
	private byte[] fileSize = new byte[4]; // size of the BMP file in bytes
	private byte[] reservedField = new byte[4]; // actual value depends on the application that creates the image 
	private byte[] offset = new byte[4]; // starting address of the byte where the bitmap image data (pixel array) can be found.
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * getter
	 * @return headerField
	 */
	public byte[] getHeaderField() {
		return this.headerField;
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
	 * setter
	 * @param offset
	 */
	public void setOffset(byte[] offset) {
		this.offset = offset;
	}

}
