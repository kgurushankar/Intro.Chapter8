package intro;

import java.util.Scanner;

public class IntroLoops {

	public static void main(String[] args) {
		IntroLoops il = new IntroLoops();
		Scanner in = new Scanner(System.in);
		System.out.println("1 - Divide two numbers");
		System.out.println("2 - Print Series");
		System.out.println("3 - Repeat Word");
		System.out.println("4 - Print Index line");
		System.out.println("5 - Adding Integers");
		System.out.println("6 - Sigma 1/n");
		System.out.println("7 - Standard of deviation");
		System.out.println("8 - Create a text circle"); // Your Choice (not part of prompt; was misunderstood)
		System.out.println("9 - Exit");
		// System.out.println("3 - ");
		int option;
		while (true) {
			try {
				System.out.print("Enter the number of the option you would like to select:");
				option = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid input");
			}
		}

		try {
			switch (option) {
			case 1: {
				System.out.print("Enter the Divisor:");
				int a = in.nextInt();
				System.out.print("Enter the Dividend:");
				int b = in.nextInt();
				int[] out = il.div(a, b);
				System.out.println(a + " divided by " + b + " is equal to " + out[0] + " R" + out[1]);
				break;
			}
			case 2: {
				System.out.print("Enter the Lower Number:");
				int a = in.nextInt();
				System.out.print("Enter the Higher Number:");
				int b = in.nextInt();
				int[] out = il.numBetweenNum(a, b);
				for (int i = 0; i < out.length; i++) {
					System.out.println(out[i]);
				}
				break;
			}
			case 3: {
				System.out.print("Enter a word:");
				String a = in.next();
				String[] out = il.repeatWordForLength(a);
				for (int i = 0; i < out.length; i++) {
					System.out.println(out[i]);
				}
				break;
			}
			case 4: {
				System.out.print("Enter the first word:");
				String a = in.next();
				System.out.print("Enter the second word:");
				String b = in.next();
				String out = il.indexEntry(a, b);
				System.out.println(out);
				break;
			}
			case 5: {
				System.out.println("How many Integers will be added?");
				int cases = in.nextInt();
				int[] a = new int[cases];
				for (int i = 0; i < cases; i++) {
					System.out.print("Enter an Integer:");
					a[i] = in.nextInt();
				}
				System.out.println("The sum is" + il.sumArr(a));
				break;
			}
			case 6: {
				System.out.println("Enter n:");
				int n = in.nextInt();
				System.out.println(
						"The sum of the series (1/1 + 1/2 + 1/3 +1/4 ... + 1/n when n is " + n + " is " + il.sigmaN(n));
				break;
			}
			case 7: {
				System.out.println("How many integers will be checked?");
				int cases = in.nextInt();
				double[] a = new double[cases];
				for (int i = 0; i < cases; i++) {
					System.out.print("Enter a number:");
					a[i] = in.nextDouble();
				}
				System.out.print("The standard of deviation of the set {");
				for (int i = 0; i < a.length - 1; i++) {
					System.out.print(a[i]);
					System.out.print(", ");
				}
				System.out.print(a[a.length - 1]);
				System.out.println("} is " + il.standardOfDeviation(a));
				break;
			}
			case 8: {
				System.out.println("Enter the radius of the circle:");
				int r = in.nextInt();
				String[] out = il.circle(r);
				int x = 1;
				String one = out[0];
				while (out[x].equals(one)) {
					out[x] = "";
					x++;
				}
				x = out.length - 2;
				String end = out[out.length - 1];
				while (out[x].equals(end)) {
					out[x] = "";
					x--;
				}
				for (int i = 0; i < out.length; i++) {
					if (!(out[i].equals(""))) {
						System.out.println(out[i]);
					}

				}
				break;
			}
			case 9: {
				System.out.println("Bye!");
				return;
			}
			default: {
				System.out.println("Please enter a valid input!");
				main(args);
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("Your input was invalid. Please provide valid input.");
		}

		main(args);
	}

	private double standardOfDeviation(double[] a) {
		double squareavg = 0;
		double avg = 0;
		int nums = a.length;
		for (int i = 0; i < nums; i++) {
			avg += a[i];
			squareavg += Math.pow(a[i], 2.0);
		}
		avg /= (double) (nums);
		avg = Math.pow(avg, 2.0);
		squareavg /= (double) (nums);
		double out = Math.sqrt(squareavg - avg);
		return out;
	}

	private double sigmaN(int n) {
		double out = 0;
		for (int a = 1; a <= n; a++) {
			out += 1.0 / (double) (a);
		}
		return out;
	}

	private int sumArr(int[] a) {
		int out = 0;
		for (int i = 0; i < a.length; i++) {
			out += a[i];
		}
		return out;
	}

	private String[] circle(int r) {
		char neg = ' ';
		char posr = '*';
		char posl = '*';
		// use dist formula
		// create line of length 2r
		// replace appropriate chars w/ *
		int w = 2 * r;
		String[] out = new String[w];
		for (int i = 0; i < out.length; i++) {
			out[i] = "";
			for (int j = 1; j <= w; j++) {
				out[i] = out[i].concat(String.valueOf(neg) + String.valueOf(neg));
			}
		}
		for (int y = -out.length / 2; y < out.length / 2; y++) {
			int x = (int) (Math.sqrt(r * r - (y) * (y) * 1.5) + .5);
			char[] current = out[y + out.length / 2].toCharArray();
			current[2 * (r - x + 1)] = posl;
			current[2 * (r + x - 1)] = posr;
			out[y + out.length / 2] = "";
			for (int i = 0; i < current.length; i++) {
				out[y + out.length / 2] += Character.valueOf(current[i]);
			}
		}
		return out;
	}

	private String indexEntry(String a, String b) {
		int c = 30 - (a.length() + b.length());
		String out = a;
		for (int i = 0; i < c; i++) {
			out = out.concat(".");
		}
		out = out.concat(b);
		return out;
	}

	private String[] repeatWordForLength(String a) {
		String[] out = new String[a.length()];
		for (int i = 0; i < a.length(); i++) {
			out[i] = a;
		}
		return out;
	}

	/**
	 * a by b out[0] = quotient out[1] = remainder
	 */
	public int[] div(int a, int b) {
		int c = a;
		int d = 0;
		while (c >= b) {
			d++;
			c -= b;
		}
		int[] out = { d, c };
		return out;
	}

	public int[] numBetweenNum(int min, int max) {
		int[] out = new int[Math.abs(max - min) + 1];
		int c = 0;
		for (int i = min; i <= max; i++) {
			out[c] = i;
			c++;
		}
		return out;
	}

}
