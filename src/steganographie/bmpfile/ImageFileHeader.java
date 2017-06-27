package steganographie.bmpfile;

public class ImageFileHeader {
	private byte[] headerField; //to identify BMP file (2 bytes)
	private byte[] fileSize; // size of the BMP file in bytes (4 bytes)
	private byte[] reservedField; // actual value depends on the application that creates the image (4 bytes)
	private byte[] offset; // starting address of the byte where the bitmap image data (pixel array) can be found.
	

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

}
