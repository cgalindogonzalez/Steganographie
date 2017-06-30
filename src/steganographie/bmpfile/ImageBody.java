package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImageBody {
	
	private BufferedImage image;
	
	/**
	 * getter
	 * @return image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * getter
	 * @param bi
	 * @return image
	 */
	public BufferedImage getImage(BufferedImage bi) {
		this.image = bi;
		return image;
	}
	
	
	/**
	 * setter
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	
	public BufferedImage hideFileWithinPixelsOfImage (File file) {
		
		return null;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
