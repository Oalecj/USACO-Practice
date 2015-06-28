/*
 ID: nikhilf1
 LANG: JAVA
 PROB: ride
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
		String n1 = f.readLine();
		String n2 = f.readLine();
		char[] n1a = n1.toCharArray();
		char[] n2a = n2.toCharArray();
		int totalValue1 = 1;
		int totalValue2 = 1;
		for (char s: n1a)
		{
		
			int temp = (int) s;
				temp = temp - 64;
				System.out.println(temp);
				totalValue1 = temp * totalValue1;
		}
		System.out.println("NEXT");
		for (char s: n2a)
		{
				int temp = (int) s;
				temp = temp - 64;
				System.out.println(temp);
				totalValue2 = temp * totalValue2;
		}
		if (totalValue1 % 47 == totalValue2 % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
