package steganographie.bmpfile;

public class BMPReader {
	
	private ImageHeader header;

	/**
	 * getter
	 * @return header
	 */
	public ImageHeader getHeader() {
		return this.header;
	}
	

	/**
	 * setter
	 * @param header
	 */
	public void setHeader(ImageHeader header) {
		this.header = header;
	}
	

}
