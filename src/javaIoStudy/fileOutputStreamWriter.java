package javaIoStudy;

import java.io.*;

public class fileOutputStreamWriter {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("JavaIoTestFiles/write.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write("这是 FileOutputStreamWriter");
			System.out.println(osw.getEncoding());
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream("JavaIoTestFiles/write.txt",true),"ISO8859_1");//true：是否追加
			osw.write("Hello Java");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
