package character.patterns;

public class InvertedTriangle {

	public static void main(String[] args) {
		final int SIZE =4;
		for (int i = 1; i <= SIZE; i++) {
			for (int j = SIZE; j > 0; j--) {
				if (j<=i){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
