package steganographie.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import steganographie.bmpfile.BMPFileReader;
import steganographie.bmpfile.BMPIdentifierEnum;
import steganographie.filetohide.FileReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/24bpp.bmp
		//		/Users/Cecilia/Documents/AgilityFactory/CursoInformatica/operation.txt

		Scanner sc = new Scanner(System.in);
		String choice = null;
		do {
			System.out.println("Please, select one option:");
			System.out.println("1. Hide a file in a BMP image.");
			System.out.println("2. Recover a file from a BMP image");

			choice = sc.nextLine();

			//Selection 1: Hide file into image
			if (choice.equals("1")) {

				System.out.println("******************************");
				System.out.println("1. HIDE A FILE IN A BMP IMAGE");
				System.out.println("******************************");
				
				System.out.println("Insert the file path of the image");
				String bmpFilePath = sc.nextLine();
				System.out.println("Insert the file name of the image");
				String bmpFileName = sc.nextLine();
				System.out.println("Insert the file path of the file to hide");
				String fileToHidePath = sc.nextLine();
				System.out.println("Insert the file name (with the extension) of the file to hide");
				String fileToHideName = sc.nextLine();
				
				//GESTIONAR CASOS EN LOS QUE SE INTRODUZCA ALGO INCORRECTO EN ESTOS ULTIMOS CAMPOS!!
				
				String bmpFile = bmpFilePath + System.getProperty("file.separator") + bmpFileName +".bmp";
				String fileToHide = fileToHidePath + System.getProperty("file.separator") + fileToHideName;

				//read the bmpFile and divide it into his parts (file header, bmp header and image body)
				BMPFileReader bmpFileReader = new BMPFileReader();
				bmpFileReader.readBMPFile(new File(bmpFile));

				//bmpFileReader.setPathDir(bmpFilePath); //to be used to saved the rebuilt image (with the hidden file inside)  

				//check if the image file is already BMP 24 bits
				byte[] headField = bmpFileReader.getFileHeader().getHeaderField();
				String bmpIdentifier = bmpFileReader.getFileHeader().getType(headField);

				byte[] cDepth = bmpFileReader.getBmpHeader().getColorDepth();
				int bitsPerPixel = bmpFileReader.getBmpHeader().getNumberOfBitsPerPixel(cDepth);

				if (BMPIdentifierEnum.getEnums().contains(bmpIdentifier) && (bitsPerPixel == 24)){

					//reckon the maximun size of the file to hide
					byte[] imWidth = bmpFileReader.getBmpHeader().getImageWidth();
					int width = bmpFileReader.getBmpHeader().getWidthOfTheImage(imWidth); 

					byte[] imHeight = bmpFileReader.getBmpHeader().getImageHeight();
					int height = bmpFileReader.getBmpHeader().getHeightOfTheImage(imHeight);

					int numberOfPixels = width*height;
					int maxSize = 3*numberOfPixels/4;

					FileReader fileReader = new FileReader();
					File file = new File(fileToHide);
					byte[] fileInformation = fileReader.getFileInformationToReconstruction(file); //get the byte array with the information of the file to hide 
					byte[] readFileArray = fileReader.readFile(file); //get the byte array with the bytes of the file to hide
					byte[] fileArray = fileReader.concatenateInformationReadArrays(fileInformation, readFileArray); //concatenate both arrays 
					byte[] pairOfBitsArray = fileReader.getPairOfBitsFromByteArray(fileArray);

					int pairOfBitsArraySize = pairOfBitsArray.length;
					//check by his size if the file can be hidden in the image  
					if (pairOfBitsArraySize > maxSize) 
						System.out.println("The file is too large to be hiden in this image");
					
					//Cuando esté corregido lo de q la imagen sea byte array, habrá que pasarlo aquí a buffered image
					else {
						BufferedImage imageWithFile = bmpFileReader.getBody().hideFileWithinPixelsOfImage(pairOfBitsArray); //hide the file in the pixel of the image and return the new image with the hidden file
						bmpFileReader.rebuildAndSaveBMPImage("new" + bmpFileName); 
						System.out.println("You can find the image in: " + bmpFilePath + System.getProperty("file.separator")+ "new" + bmpFileName + ".bmp");
					}
				} 

				else {
					System.out.println("The image is not a BMP 24 bits file");
				}


			}

			//Selection 2. recover a file from an image
			else if (choice.equals("2")) {
				
				System.out.println("***********************************");
				System.out.println("1. RECOVER A FILE FROM A BMP IMAGE");
				System.out.println("***********************************");
				
				System.out.println("Insert the file path of the image");
				String bmpFilePath = sc.nextLine();
				System.out.println("Insert the file name of the image");
				String bmpFileName = sc.nextLine();
				
				//GESTIONAR CASOS EN LOS QUE SE INTRODUZCA ALGO INCORRECTO EN ESTOS ULTIMOS CAMPOS!!
				
				String bmpFile = bmpFilePath + System.getProperty("file.separator") + bmpFileName +".bmp";
				
				BMPFileReader bmpFileReader = new BMPFileReader();
				bmpFileReader.readBMPFile(new File(bmpFile));
				
				//check if the image file is already BMP 24 bits
				byte[] headField = bmpFileReader.getFileHeader().getHeaderField();
				String bmpIdentifier = bmpFileReader.getFileHeader().getType(headField);

				byte[] cDepth = bmpFileReader.getBmpHeader().getColorDepth();
				int bitsPerPixel = bmpFileReader.getBmpHeader().getNumberOfBitsPerPixel(cDepth);

				if (BMPIdentifierEnum.getEnums().contains(bmpIdentifier) && (bitsPerPixel == 24)){
					
					//Cuando esté corregido lo de q la imagen sea byte array, habrá que pasarlo aquí a buffered image
					BufferedImage bufferedImage = bmpFileReader.getBody().getImage();
					byte[] pairOfBitsToRecoverTheFile = bmpFileReader.getBody().recoverHiddenBytesFromTheImage(bufferedImage);
					
					FileReader fileReader = new FileReader();
					byte[] arrayToRecoverTheFile = fileReader.getByteArrayFromPairOfBits(pairOfBitsToRecoverTheFile);
					
					//get the size of the hidden file
					long fileLehgth = fileReader.getFileSizeFromRecoveredArray(arrayToRecoverTheFile);
					
					//get a byte array from the recovered array whose length is the file size (after removing the file information located on the first bytes)
					byte[] fileArray = fileReader.getFileArrayFromRecoveredArray(arrayToRecoverTheFile, fileLehgth);
					
					//get the extension of the hidden file
					String fileExtension = fileReader.getFileExtensionFromRecoveredArray(arrayToRecoverTheFile);
					
					//save the file
					fileReader.saveFile(fileArray, bmpFilePath, fileExtension);
					
					System.out.println("You can find the file in :" + System.getProperty("file.separator") + "recovered_file." + fileExtension);
					
				}
				
				else {
					System.out.println("The image is not a BMP 24 bits file");
				}
				
			}
			
			//Selection is not 1 or 2
			else{
				System.out.println("Wrong selection. The options are 1 or 2");
			}


		} while (!choice.equals("1") && !choice.equals("2")); // to restart if the selection is not 1 or 2
		sc.close();
	}

}
