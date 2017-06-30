package steganographie.bmpfile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BMPFileFraction {
	
	/**
	 * transform a byte array in an integer
	 * @param b
	 * @return
	 */
	public int byteArrayToInt (byte[] b) {
		    return ByteBuffer.wrap(b).getInt();
		    
	}
	
	/**
	 * get a part of a file (using a BufferedInputStream object) as a byte array
	 * @param bis 
	 * @param i
	 * @return 
	 */
	public byte[] readPartOfFile(BufferedInputStream bis, int i) {
		byte[] b = new byte[i];
		try {
			bis.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	

}
