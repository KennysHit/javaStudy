package javaIoStudy;

import java.io.*;

public class fileInputStream {

	public static void main(String[] args) {
		long num = 0,b = 0;
		try {
			FileInputStream fis = new FileInputStream("JavaIoTestFiles/getchar.txt");
			while((b=fis.read())!=-1) {
				System.out.print((char)b);
				num++;
			}
			fis.close();
			System.out.println();
			System.out.println("一共读取了 "+num+" 个字节");
		}catch (IOException e) {
			System.out.println("文件读取错误");
			System.exit(-1);
		}
	}
}