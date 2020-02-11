package javaIoStudy;
import java.io.*;
public class fileWriter {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("JavaIoTestFiles/write.txt");
			for(int i=0;i<100;i++) {
				fw.write((char)i);
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
