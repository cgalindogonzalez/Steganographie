package steganographie.bmpfile;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageBody extends BMPFileFraction {

	//private byte[] image;
	private BufferedImage image;
	/**
	 * getter
	 * @return image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	//	/**
	//	 * getter
	//	 * @param bi
	//	 * @return image
	//	 */
	//	public byte[] getImage(BufferedInputStream bis) {
	//		while()
	//	}

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


	public byte[] byteArrayFromImage(BufferedImage bi) {
		
		byte [] imageInByte = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			ImageIO.write(bi, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imageInByte;

	}

	public BufferedImage imageFromByteArray(byte[] b) {
		InputStream is = new ByteArrayInputStream(b);
		BufferedImage bImageFromArray = null;
		try {
			 bImageFromArray= ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bImageFromArray;

	}

	public BufferedImage hideFileWithinPixelsOfImage (byte[] byteArray) {
		int imageWidth = this.image.getWidth();
		int imageHeight = this.image.getHeight();

		for (int x = 0; x < imageWidth; x++) {
			for (int y = 0; y < imageHeight; y++) {
				int rgb = this.image.getRGB(x, y);
				Color color = new Color(rgb, true);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();

				int redRounded = (red-red%4);
				int greenRounded = (green-green%4);
				int blueRounded = (blue-blue%4);

				int i = (y + x*imageWidth);
				while (byteArray.length < i) {
					red = redRounded + byteArray[i];
					green = greenRounded + byteArray[i+1];
					blue = blueRounded + byteArray[i+2];
					i+=3;
				}
				
				Color newColor = new Color(red, green, blue);
				this.image.setRGB(x, y, newColor.getRGB());
			}
		}
		return image;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
