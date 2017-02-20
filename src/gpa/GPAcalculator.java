package gpa;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GPAcalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the GPA calculator.");
		boolean mode;
		while (true) {
			try {
				System.out.print("Would you like to have \"+\" and \"-\" affect your GPA? (y/n)");
				String a = in.nextLine().toLowerCase();
				if (a.equals("y")) {
					mode = true;
					break;
				} else if (a.equals("n")) {
					mode = false;
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please enter \"y\" or \"n\"");
			}
		}
		System.out.println("Enter the grades you have recieved separated by commas and/or spaces.");
		String grades = in.nextLine();

		grades.replaceAll(", ", " ");
		grades.replaceAll(" ,", " ");
		grades.replaceAll(",", " ");

		String[] set = grades.split(" ");
		int num = set.length;
		System.out.println("You have entered " + num + " classes.");
		double total = 0;
		for (int i = 0; i < num; i++) {
			if (set[i].toUpperCase().contains("A") && set[i].length() <= 2) {
				total += 4.00;
				if (mode && set[i].toUpperCase().contains("+")) {
					total += 0.00;
				} else if (mode && set[i].toUpperCase().contains("-")) {
					total -= 0.30;
				}
			} else if (set[i].toUpperCase().contains("B") && set[i].length() <= 2) {
				total += 3.00;
				if (mode && set[i].toUpperCase().contains("+")) {
					total += 0.33;
				} else if (mode && set[i].toUpperCase().contains("-")) {
					total -= 0.30;
				}
			} else if (set[i].toUpperCase().contains("C") && set[i].length() <= 2) {
				total += 2.00;
				if (mode && set[i].toUpperCase().contains("+")) {
					total += 0.33;
				} else if (mode && set[i].toUpperCase().contains("-")) {
					total -= 0.30;
				}
			} else if (set[i].toUpperCase().contains("D") && set[i].length() <= 2) {
				total += 1.00;
				if (mode && set[i].toUpperCase().contains("+")) {
					total += 0.33;
				} else if (mode && set[i].toUpperCase().contains("-")) {
					total -= 0.30;
				}
			} else if (set[i].toUpperCase().contains("F") && set[i].length() <= 2) {
				total += 0.00;

			} else {
				System.out.println("The grade " + set[i] + " is invalid.");
				System.out.println("Removing it...");
				num--;
			}
		}
		double GPA = total / num;
		DecimalFormat money = new DecimalFormat("0.00");
		System.out.println("Your GPA is " + money.format(GPA));

	}

}
