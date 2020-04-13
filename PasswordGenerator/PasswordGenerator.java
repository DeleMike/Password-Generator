
package git_github;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author AKIN Used to generate a random password
 */
public class PasswordGenerator {
	char[] bigLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	char[] smallLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	String password = "";
	int bigLetterPos, digitsPos, smallLetterPos, bigLetterCount = 0, digitsCount = 0, smallLetterCount = 0;

	/** This is used to generate a random password of length 8 */
	public void generatePassword() {
		for (int i = 0; i < bigLetters.length; i++) {
			// get a random position
			bigLetterPos = ThreadLocalRandom.current().nextInt(0, 26);
			// add to password string
			password += bigLetters[bigLetterPos];
			bigLetterCount++;

			if (bigLetterCount == 2) {
				break;
			}
		}

		System.out.println("Added bigLetters: " + password);

		// for digits
		for (int i = 0; i < digits.length; i++) {
			digitsPos = ThreadLocalRandom.current().nextInt(0, 10);
			password += digits[digitsPos];
			digitsCount++;

			if (digitsCount == 2) {
				break;
			}
		}

		System.out.println("Added digits: " + password);

		for (int i = 0; i < smallLetters.length; i++) {
			smallLetterPos = ThreadLocalRandom.current().nextInt(0, 26);
			password += smallLetters[smallLetterPos];
			smallLetterCount++;

			if (smallLetterCount == 4) {
				break;
			}
		}

		System.out.println("Added small letters " + password);

		// shuffle string
		char[] passwordStr = password.toCharArray();
		ArrayList<Character> str = new ArrayList<>();
		for (char c : passwordStr) {
			str.add(c);
		}

		StringBuilder shuffledPassword = new StringBuilder(passwordStr.length);
		while (str.size() != 0) {
			int randPicker = (int) (Math.random() * str.size());
			shuffledPassword.append(str.remove(randPicker)); // this where the main shuffling takes place

		}
		
		System.out.println("New Password: " + shuffledPassword);
	}

}
