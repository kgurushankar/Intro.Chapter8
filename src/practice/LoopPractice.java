package practice;

public class LoopPractice {
	public static void main(String[] args) {
		for (int i = 1; i <= 11; i++) {
			System.out.println("The number of iterations is " + i);
		}
		int count = 1;
		int sum = 12;
		while (count < 15) {
			sum += count;
			System.out.println("Iteration #" + count);
			count++;
		}
		System.out.println(sum);

		count = 1;
		do {
			System.out.println("The decrement of sum is " + sum + " in iteration #" + count);
			sum--;
			count++;
		} while (sum > 0);
	}
}
