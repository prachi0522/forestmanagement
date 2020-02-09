package com.capgimini.forestmanagementjdbc.main;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPage {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("*************** Welcome Admin ****************");
		System.out.println("Please Login to your account.........");
		System.out.println("********************************");
		System.out.println("Please enter your Username");
		String userName = sc.next();
		Pattern pattern1 = Pattern.compile("^[A-za-z_]{6,20}$");
		boolean isCorrect1 = true;
		do {
			Matcher matcher1 = pattern1.matcher(userName);

			if (matcher1.matches()) {
				isCorrect1 = false;
			} else {
				System.err.println("Your Username is invalid. Please enter valid Username");
				userName = sc.next();
			}
		} while (isCorrect1);
		System.out.println("Please enter your password");
		String password = sc.next();
		Pattern pattern2 = Pattern.compile("root");
		boolean isCorrect2 = true;
		do {
			Matcher matcher2 = pattern2.matcher(password);

			if (matcher2.matches()) {
				isCorrect2 = false;
			} else {
				System.err.println("Your Password is invalid. Please enter valid Password");
				password = sc.next();
			}
		} while (isCorrect2);
		MainForestry.main(null);

	}

}