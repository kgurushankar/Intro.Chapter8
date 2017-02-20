package character.patterns;

public class Diamond {

	public static void main(String[] args) {
		final int WIDTH = 7;
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
			cWidth += 2;
		}
		cWidth -= (WIDTH % 2 == 0) ? 2 : 4;
		while (cWidth > 0) {
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
			cWidth -= 2;
		}
	}

}
