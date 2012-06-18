package com.fancythinking.reg.hibernate_example.bean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class BinaryFileUtil {

	static Logger logger = Logger.getLogger(BinaryFileUtil.class);

	/** Read the given binary file, and return its contents as a byte array. */
	public static byte[] read(String fileName) {
		logger.debug("Reading in binary file named : " + fileName);
		byte[] result = null;
		try {
			File file = new File(fileName);
			logger.debug("File exists? " + file.exists());
			result = new byte[(int) file.length()];
			logger.debug("File size: " + file.length());

			InputStream input = null;
			try {
				int totalBytesRead = 0;
				input = new BufferedInputStream(new FileInputStream(file));
				while (totalBytesRead < result.length) {
					int bytesRemaining = result.length - totalBytesRead;
					// input.read() returns -1, 0, or more :
					int bytesRead = input.read(result, totalBytesRead,
							bytesRemaining);
					if (bytesRead > 0) {
						totalBytesRead = totalBytesRead + bytesRead;
					}
				}
				/*
				 * the above style is a bit tricky: it places bytes into the
				 * 'result' array; 'result' is an output parameter; the while
				 * loop usually has a single iteration only.
				 */
				logger.debug("Num bytes read: " + totalBytesRead);
			} finally {
				logger.debug("Closing input stream.");
				input.close();
			}
		} catch (FileNotFoundException ex) {
			logger.debug("File not found.");
		} catch (IOException ex) {
			logger.debug(ex);
		}
		return result;
	}
	
	public static void writeFile(String filePath, byte[] array) {
		FileOutputStream fout = null;
		File file = null;
		try {
			file = new File(filePath);
			fout = new FileOutputStream(file);			
			fout.write(array);
			fout.flush();	
			
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {		
			if ( fout != null) {
				try {
					fout.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}			
		}
		
	}
}
