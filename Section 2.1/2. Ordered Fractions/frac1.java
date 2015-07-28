/*
ID: nikhilf1
LANG: JAVA
TASK: frac1
 */
import java.io.*;
import java.util.*;


public class frac1 {

	class Fraction implements Comparable<Fraction>{
		int numerator;
		int denominator;
		public String toString() {
			return String.format("%s/%s", numerator, denominator);
		}
		public int compareTo(Fraction other) {
			return numerator * other.denominator-  denominator * other.numerator ;
		}
		public Fraction(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}

	public String[] solve(int n) {

		ArrayList<Fraction> fractions = new ArrayList<Fraction>();
		fractions.add(new Fraction(0, 1));
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (gcd(i, j) == 1) {
					fractions.add(new Fraction(i, j));
				}
			}
		}
		Collections.sort(fractions);

		ArrayList<String> res = new ArrayList<String>();
		for (Fraction f : fractions) {
			res.add(f.toString());
		}
		return res.toArray(new String[0]);
	}

	int gcd(int x, int y) {
		if (y > x) {
			int temp = y;
			y = x;
			x = temp;
		}

		while (x % y > 0) {
			x = x % y;
			if (y > x) {
				int temp = y;
				y = x;
				x = temp;
			}
		}
		return y;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "frac1";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		String[] res = (new frac1()).solve( n);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String r : res) {
			out.println(r);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
