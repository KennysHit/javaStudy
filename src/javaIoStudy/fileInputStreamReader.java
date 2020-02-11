package javaIoStudy;

import java.io.*;

public class fileInputStreamReader {

	public static void main(String[] args) {
		try {
			String s;
			FileInputStream fis = new FileInputStream("JavaIoTestFiles/FileTest.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			while((s=br.readLine())!=null) {
				System.out.print(s);
				System.out.println();
			}
			fis.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
