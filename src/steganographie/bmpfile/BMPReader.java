package steganographie.bmpfile;

public class BMPReader {
	
	private ImageHeader header;
	private ImageBody body;
	

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
	

}
