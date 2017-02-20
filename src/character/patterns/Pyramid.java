package character.patterns;

public class Pyramid {

	public static void main(String[] args) {
		// final int HEIGHT = 4;
		final int WIDTH = 100;
		int cWidth = (WIDTH % 2 == 0) ? 2 : 1;
		while (cWidth <= WIDTH) {
			int side = (WIDTH - cWidth) / 2;
			for (int j = 1; j <= side; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= cWidth; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= side; j++) {
				System.out.print(" ");
			}
			System.out.println();
			cWidth+=2;
		}

	}

}
