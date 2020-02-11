package javaIoStudy;

import java.io.*;

public class fileReader {

	public static void main(String[] args) {
		try {
			int c = 0;
			FileReader fr = new FileReader("JavaIoTestFiles/fileTest.txt");
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("文件读取错误");
			System.exit(-1);
		}
	}

}
