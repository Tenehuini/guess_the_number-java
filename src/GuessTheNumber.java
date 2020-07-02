import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {

	public static void main(String[] args) {
		int maxNumber = 0;
		
		if (args.length >= 2 || args.length == 0) {
			System.out.println("Only one argument is valid, the max number allowed");
			System.exit(1);
		}
		
		try {
			maxNumber = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.out.println("Argument must be a number.");
			System.exit(1);
		}
		
		if (maxNumber <= 1) {
			System.out.println("Number must be positive and higher than 1");
			System.exit(1);
		}
		
		int randomNumber = ThreadLocalRandom.current().nextInt(1, maxNumber + 1);
		int guess = -1;
		System.out.println(String.format("Guess the number, from 1 to %d", maxNumber));
		
		try (Scanner scanner = new Scanner(System.in);) {
			do {
				guess = scanner.nextInt();
				if (guess > randomNumber) {
					System.out.println("The number is lower");
				} else {
					if (guess < randomNumber) {
						System.out.println("The number is higher");
					}
				}
			} while (guess != randomNumber);
		}
		
		System.out.println("You guessed the number!");
	}
}