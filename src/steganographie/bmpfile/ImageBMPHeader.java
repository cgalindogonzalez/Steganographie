package steganographie.bmpfile;

public class ImageBMPHeader {
	
	private byte[] headerSize; //the size of this header, i.e. 40 bytes (4 bytes)
	private byte[] imageWidth; // the bitmap width in pixels (signed integer) (4 bytes)
	private byte[] imageHeight; // the bitmap height in pixels (signed integer) (4 bytes)
	private byte[] colorPlanes; // the number of color planes (must be 1) (2 bytes)
	private byte[] colorDepth; // the number of bits per pixel, which is the color depth of the image. Typical values are 1, 4, 8, 16, 24 and 32 (2 bytes)
	private byte[] compressionMethod; // the compression method being used (0 means non compression) (4 bytes)
	private byte[] imageSize; // the image size. This is the size of the raw bitmap data (4 bytes)
	private byte[] horizontalResolution; // pixel per meter, signed integer (4 bytes)
	private byte[] verticalResolution; // pixel per meter, signed integer (4 bytes)
	private byte[] paletteColors; // the number of colors in the color palette, or 0 to default to 2n (4 bytes)
 	private byte[] importantColors; // the number of important colors used, or 0 when every color is important; generally ignored (4 bytes)
	
 	/**
 	 * getter
 	 * @return headerSize
 	 */
 	public byte[] getHeaderSize() {
		return this.headerSize;
	}
 	
 	/**
 	 * setter
 	 * @param headerSize
 	 */
	public void setHeaderSize(byte[] headerSize) {
		this.headerSize = headerSize;
	}

	/**
	 * getter
	 * @return imageWidth
	 */
	public byte[] getImageWidth() {
		return this.imageWidth;
	}

	/**
	 * setter
	 * @param imageWidth
	 */
	public void setImageWidth(byte[] imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * getter
	 * @return imageHeight
	 */
	public byte[] getImageHeight() {
		return this.imageHeight;
	}

	/**
	 * setter
	 * @param imageHeight
	 */
	public void setImageHeight(byte[] imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * getter
	 * @return colorPlanes
	 */
	public byte[] getColorPlanes() {
		return this.colorPlanes;
	}

	/**
	 * setter
	 * @param colorPlanes
	 */
	public void setColorPlanes(byte[] colorPlanes) {
		this.colorPlanes = colorPlanes;
	}

	/**
	 * getter
	 * @return colorDepth
	 */
	public byte[] getColorDepth() {
		return this.colorDepth;
	}

	/**
	 * setter
	 * @param colorDepth
	 */
	public void setColorDepth(byte[] colorDepth) {
		this.colorDepth = colorDepth;
	}

	/**
	 * getter
	 * @return compressionMethod
	 */
	public byte[] getCompressionMethod() {
		return this.compressionMethod;
	}

	/**
	 * setter
	 * @param compressionMethod
	 */
	public void setCompressionMethod(byte[] compressionMethod) {
		this.compressionMethod = compressionMethod;
	}

	/**
	 * getter
	 * @return imageSize
	 */
	public byte[] getImageSize() {
		return this.imageSize;
	}

	/**
	 * setter
	 * @param imageSize
	 */
	public void setImageSize(byte[] imageSize) {
		this.imageSize = imageSize;
	}

	/**
	 * getter
	 * @return horizontalResolution
	 */
	public byte[] getHorizontalResolution() {
		return this.horizontalResolution;
	}

	/**
	 * setter
	 * @param horizontalResolution
	 */
	public void setHorizontalResolution(byte[] horizontalResolution) {
		this.horizontalResolution = horizontalResolution;
	}

	/**
	 * getter
	 * @return verticalResolution
	 */
	public byte[] getVerticalResolution() {
		return this.verticalResolution;
	}

	/**
	 * setter
	 * @param verticalResolution
	 */
	public void setVerticalResolution(byte[] verticalResolution) {
		this.verticalResolution = verticalResolution;
	}

	/**
	 * getter
	 * @return paletteColors
	 */
	public byte[] getPaletteColors() {
		return this.paletteColors;
	}

	/**
	 * setter
	 * @param paletteColors
	 */
	public void setPaletteColors(byte[] paletteColors) {
		this.paletteColors = paletteColors;
	}

	/**
	 * getter
	 * @return importantColors
	 */
	public byte[] getImportantColors() {
		return this.importantColors;
	}

	/**
	 * setter
	 * @param importantColors
	 */
	public void setImportantColors(byte[] importantColors) {
		this.importantColors = importantColors;
	}
	
}
