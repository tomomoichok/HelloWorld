package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld {

	public static void main(String[] args) {
		fileread();
		filewrite();
	}

	public static void fileread() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File f = new File("C:\\pleiades\\temp\\test.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void filewrite() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			File f = new File("C:\\pleiades\\temp\\test.txt");

			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			pw.println("書き込む内容１行目");
			pw.println("書き込む内容２行目");

			pw.close();
			System.out.println("書き込み完了");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
