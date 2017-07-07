package steganographie.bmpfile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.imageio.ImageIO;

public class ImageBody {

	private byte[] rawBytes;

	/**
	 * getter
	 * @return rawBytes
	 */
	public byte[] getRawBytes() {
		return rawBytes;
	}


	/**
	 * setter
	 * @param rawBytes
	 */
	public void setRawBytes(byte[] rawBytes) {
		this.rawBytes = rawBytes;
	}

	
	/**
	 * convert a buffered image into a byte array 
	 * @param bi
	 * @return
	 * @throws IOException 
	 */
	public byte[] byteArrayFromImage(BufferedImage bi) throws IOException {
		
		byte [] imageInByte = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ImageIO.write(bi, "bmp", baos);
		imageInByte = baos.toByteArray();
		baos.close();
		
		return imageInByte;

	}

	/**
	 * convert a byte array into a buffered image
	 * @param b
	 * @return
	 * @throws IOException 
	 */
	public BufferedImage imageFromByteArray(byte[] b) throws IOException {
		InputStream is = new ByteArrayInputStream(b);
		
		return ImageIO.read(is);
	}

	
	
	
	

	public void read(RandomAccessFile raf, int offset, int size) throws IOException {
		this.rawBytes = new byte[size];
		raf.seek(offset);
		raf.read(this.rawBytes);
	}


	public void write(RandomAccessFile raf, int offset) throws IOException {
		if (this.rawBytes == null) 
			throw new IllegalStateException("no puedes hacer write si antes no has inicializado rawBytes");
		raf.seek(offset);
		raf.write(this.rawBytes);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
