package javaIoStudy;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class filePrintStream {

	public static void main(String[] args) {
		try {
			String s = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			FileWriter fw = new FileWriter("JavaIoTestFiles/logfile.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			while((s=br.readLine())!=null) {
				if(s.equalsIgnoreCase("exit"))break;
				System.out.println(s.toUpperCase());
				pw.println("---------");
				pw.println(s.toUpperCase());
				pw.flush();
			}
			pw.println("===="+new Date()+"====");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
