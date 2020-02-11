package javaIoStudy;

import java.io.*;

public class fileBuffer {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("JavaIoTestFiles/write.txt"));
			BufferedReader br = new BufferedReader(new FileReader("JavaIoTestFiles/write.txt"));
			String s = null;
			for(int i=0;i<10;i++) {
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s=br.readLine())!=null) {
				System.out.println(s);
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
