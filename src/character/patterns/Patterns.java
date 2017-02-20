package character.patterns;

import java.util.Scanner;

public class Patterns {
	private Scanner in;
	private char positive;
	private char negative;

	public Patterns() {
		this('*', ' ');
	}

	public Patterns(char positive, char negative) {
		in = new Scanner(System.in);
		this.positive = positive;
		this.negative = negative;
	}

	public static void main(String[] args) {
		Patterns a = new Patterns('*', ' ');
		while (a.menu()) {
			a.delay(5000);
		}
	}

	/** Prints a console menu to choose which method to run */
	public boolean menu() {
		typePrintln("1 - Triangle");
		typePrintln("2 - Square");
		typePrintln("3 - Inverted Triangle");
		typePrintln("4 - Pyramid");
		typePrintln("5 - Diamond");
		typePrintln("6 - Hollow Circle");
		typePrintln("7 - Filled Circle");
		typePrintln("8 - Quit");
		typePrintln("Enter the option number which you would like to be printed.");
		typePrintln("Your choice:");
		int option = inputInt(8);
		switch (option) {
		case (1): {
			System.out.print("Enter the height of the triangle");
			int size = inputInt(-1);
			Triangle(size);
			break;
		}
		case (2): {
			System.out.print("Enter the height of the square");
			int size = inputInt(-1);
			Square(size);
			break;
		}
		case (3): {
			System.out.print("Enter the height of the inverted triangle");
			int size = inputInt(-1);
			InvertedTriangle(size);
			break;
		}
		case (4): {
			System.out.print("Enter the height of the pyramid");
			int height = inputInt(-1);
			PyramidByHeight(height);
			break;
		}
		case (5): {
			System.out.print("Enter the height of the diamond");
			int width = inputInt(-1);
			Diamond(width);
			break;
		}
		case (6): {
			System.out.print("Enter the radius of the circle");
			int r = inputInt(-1);
			String[] out = Circle(r, false);
			for (int i = 0; i < out.length; i++) {
				// if (!(out[i].equals(""))) {
				System.out.println(out[i]);
				// }
			}
			break;
		}
		case (7): {
			System.out.print("Enter the radius of the circle");
			int r = inputInt(-1);
			String[] out = Circle(r, true);
			for (int i = 0; i < out.length; i++) {
				// if (!(out[i].equals(""))) {
				System.out.println(out[i]);
				// }
			}
			break;
		}
		case (8): {
			System.out.println("Bye!");
			System.out.println();
			return false;
		}
		}
		return true;
	}

	/**
	 * @param size
	 *            is the height/base of the triangle
	 */
	public void Triangle(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(positive);
			}
			System.out.println();
		}
	}

	/**
	 * @param size
	 *            is the side length of the square
	 */
	public void Square(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(positive);
			}
			System.out.println();
		}
	}

	/**
	 * @param width
	 *            is length of the last line
	 */
	public void PyramidByWidth(int width) {
		int cWidth = (width % 2 == 0) ? 2 : 1;
		while (cWidth <= width) {
			System.out.println(PyramidLine(width, cWidth));
			cWidth += 2;
		}
	}

	public void PyramidByHeight(int height) {
		PyramidByWidth((height * 2) - 1);
	}

	/**
	 * @param size
	 *            is the height/base of the triangle
	 */
	public void InvertedTriangle(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = size; j > 0; j--) {
				if (j <= i) {
					System.out.print(positive);
				} else {
					System.out.print(negative);
				}
			}
			System.out.println();
		}
	}

	/**
	 * @param width
	 *            the length of the longest line (can be either width or height)
	 */
	public void Diamond(int width) {
		int cWidth = (width % 2 == 0) ? 2 : 1;
		while (cWidth <= width) {
			System.out.println(PyramidLine(width, cWidth));
			cWidth += 2;
		}
		cWidth -= (width % 2 == 0) ? 2 : 4;
		while (cWidth > 0) {
			System.out.println(PyramidLine(width, cWidth));
			cWidth -= 2;
		}
	}

	/**
	 * @param radius
	 *            radius of the circle
	 * @return
	 */
	public String[] Circle(int radius, boolean filled) {
		// use dist formula
		// create line of length 2r
		// replace appropriate chars w/ *
		int w = 2 * radius;
		String[] out = new String[w];
		for (int i = 0; i < out.length; i++) {
			out[i] = "";
			for (int j = 1; j <= w; j++) {
				out[i] = out[i].concat(String.valueOf(negative) + String.valueOf(negative));
			}
		}
		for (int y = -out.length / 2; y < out.length / 2; y++) {
			int x = (int) (Math.sqrt(radius * radius - (y) * (y)) + .5);
			char[] current = out[y + out.length / 2].toCharArray();
			current[2 * (radius - x + 1)] = positive;
			current[2 * (radius + x - 1)] = positive;
			out[y + out.length / 2] = "";
			for (int i = 0; i < current.length; i++) {
				out[y + out.length / 2] += Character.valueOf(current[i]);
			}
		}
		if (filled) {
			for (int i = 0; i < out.length; i++) {
				boolean sub = false;
				char[] line = out[i].toCharArray();
				for (int j = 0; j < out[i].length(); j++) {
					char curr = line[j];
					if (curr == positive) {
						sub = !(sub);
					}
					if (sub) {
						line[j] = positive;
					}
				}
				out[i] = "";
				for (int j = 0; j < line.length; j++) {
					out[i] += Character.valueOf(line[j]);
				}
			}
		}
		return out;
	}

	/**
	 * Prints a line of the pyramid
	 * 
	 * @param width
	 *            total length of the line
	 * @param currentWidth
	 *            length of the stars in the line
	 * @return the line
	 */
	private String PyramidLine(int width, int currentWidth) {
		int side = (width - currentWidth) / 2;
		String out = "";
		for (int j = 1; j <= side; j++) {
			out += (negative);
		}
		for (int j = 1; j <= currentWidth; j++) {
			out += (positive);
		}
		for (int j = 1; j <= side; j++) {
			out += (negative);
		}
		return out;
	}

	/**
	 * @param maxval
	 *            the highest integer that can be entered — use -1 for no limit
	 * @return the value inputed by the user
	 */
	private int inputInt(int maxval) {
		int num;
		while (true) {
			try {
				num = Integer.parseInt(in.nextLine());
				if (maxval != -1 && num > maxval) {
					throw new Exception();
				}
				return num;
			} catch (Exception e) {
				System.out.println("Please enter a valid input.");
			}
		}
	}

	private void delay(long ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			// nothing here
		}
	}

	private void typePrint(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			delay(60); // could be 80
		}
	}

	private void typePrintln(String text) {
		typePrint(text);
		System.out.println();
		delay(180); // could be 240
	}
}
