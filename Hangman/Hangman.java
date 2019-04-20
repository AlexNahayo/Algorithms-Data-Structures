/**
 * Hangman using dictionary.txt
 * @author (Alex Nahayo) 
 * @version (26-03-2018)
 */


import java.util.Scanner;

public class Hangman {

	//omport scanner class adn filIO

	 private static FileIO reader = new FileIO();
     private static Scanner scan = new Scanner(System.in);


	private static String[] words = reader.load("X://CS211//dictionary.txt"); 
	private static String word = words[(int) (Math.random() * words.length)];
	//replaces each character with the word
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	//DECLARE COUNT VARABLE.(COUNTS THE NUMBER OF TIMES THE USER GETS THE ANSWER WRONG)
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//THE LOOP GOES THE NUMBER OF TIMES WE DECIDED TO FOR THE GAME TO BE OVER WHICH 7 BASED ON OUR ILLUSTRATION
		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(asterisk);
			//Here you are asked to guess a letter
			String guess = sc.next();//takes the next letter each time.
			hang(guess);
		}
		sc.close();
	}

	public static void hang(String guess) {
		String newasterisk = "";

		//once the user inputs a letter it checks if the letter is contained in the word via a loop.(from the first to the last)
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

//if the letter is wrong  in the word, it increments the count based on our hangman image below
		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		}
//if the letter is correct.
		 else {
			asterisk = newasterisk;
		}

//if the word is correct in the word
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}


//the actual hangman visulas
	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}