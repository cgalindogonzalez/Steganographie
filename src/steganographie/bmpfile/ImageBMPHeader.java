package steganographie.bmpfile;

import java.io.BufferedInputStream;

public class ImageBMPHeader extends BMPFileFraction {
	
	private byte[] headerSize = new byte[4]; //the size of this header, i.e. 40 bytes
	private byte[] imageWidth = new byte[4]; // the bitmap width in pixels (signed integer)
	private byte[] imageHeight = new byte[4]; // the bitmap height in pixels (signed integer)
	private byte[] colorPlanes = new byte[2]; // the number of color planes (must be 1)
	private byte[] colorDepth = new byte[2]; // the number of bits per pixel, which is the color depth of the image. Typical values are 1, 4, 8, 16, 24 and 32
	private byte[] compressionMethod = new byte[4]; // the compression method being used (0 means non compression) 
	private byte[] imageSize = new byte[4]; // the image size. This is the size of the raw bitmap data
	private byte[] horizontalResolution = new byte[4]; // pixel per meter, signed integer 
	private byte[] verticalResolution = new byte[4]; // pixel per meter, signed integer
	private byte[] paletteColors = new byte[4]; // the number of colors in the color palette, or 0 to default to 2n 
 	private byte[] importantColors = new byte[4]; // the number of important colors used, or 0 when every color is important; generally ignored
	
 	/**
 	 * getter
 	 * @return headerSize
 	 */
 	public byte[] getHeaderSize() {
		return this.headerSize;
	}
 	
 	/**
	 * getter
	 * @param bis
	 * @return headerFSize
	 */
	public byte[] getHeaderSize(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return imageWidth
	 */
	public byte[] getImageWidth(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return imageHeight
	 */
	public byte[] getImageHeight(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return colorPlanes
	 */
	public byte[] getColorPlanes(BufferedInputStream bis) {
		return readPartOfFile(bis, 2);
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
	 * getter
	 * @param bis
	 * @return colorDepth
	 */
	public byte[] getColorDepth(BufferedInputStream bis) {
		return readPartOfFile(bis, 2);
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
	 * getter
	 * @param bis
	 * @return compressionMethod
	 */
	public byte[] getCompressionMethod(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return imageSize
	 */
	public byte[] getImageSize(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return horizontalResolution
	 */
	public byte[] getHorizontalResolution(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return verticalResolution
	 */
	public byte[] getVerticalResolution(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return paletteColors
	 */
	public byte[] getPaletteColors(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
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
	 * getter
	 * @param bis
	 * @return importantColors
	 */
	public byte[] getImportantColors(BufferedInputStream bis) {
		return readPartOfFile(bis, 4);
	}
	
	
	/**
	 * setter
	 * @param importantColors
	 */
	public void setImportantColors(byte[] importantColors) {
		this.importantColors = importantColors;
	}
	
}
