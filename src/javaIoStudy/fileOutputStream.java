package javaIoStudy;

import java.io.*;

public class fileOutputStream {

	public static void main(String[] args) {
		int b = 0;
		try {
			FileInputStream fis = new FileInputStream("JavaIoTestFiles/getchar.txt");
			FileOutputStream fos = new FileOutputStream("JavaIoTestFiles/fileTest.txt");
			while((b=fis.read())!=-1) {
				fos.write(b);
			}
			System.out.println("complete");
			fis.close();
			fos.close();
			System.out.println();
		} catch (IOException e) {
			System.out.println("文件读取错误");
			System.exit(-1);
		}
	}

}
