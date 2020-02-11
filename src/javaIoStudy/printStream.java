package javaIoStudy;

import java.io.*;

public class printStream {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("JavaIoTestFiles/write.txt");
			PrintStream ps = new PrintStream(fos);
			if (ps!=null) {
				System.setOut(ps);
			}
			int ln = 0;
			for(char c=0;c<5000;c++) {
				System.out.print(c+" ");
				if(ln++>=100) {
					System.out.println();
					ln = 0;
				}
			}
			ps.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
