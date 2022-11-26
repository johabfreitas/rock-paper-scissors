package entities;

import java.util.Random;
import java.util.Scanner;

public record JoKenPo(

		Player user, Player IA, int rounds

) {

	public void toPlay() {
		System.out.println("\n******** WELCOME, " + user.getName() + " ********\n");

		for (int i = 1; i <= rounds; i++) {
			int choiceuser = choiceUser();
			if (choiceuser < 1 || choiceuser > 3) {
				System.out.println("\nINVALID MOVE! (1, 2 OR 3): ");
				System.out.println("\tPOINT TO " + IA.getName() + "\n");
				IA.incrementScore();
				// continue;
			}
			
			int choiceia = choiceIA();
			
			System.out.println("\n" + choiceuser + " X " + choiceia);
		}
	}
	
	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(1, 3);
	}

	private int choiceUser() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1 - Rock");
		System.out.println("2 - Paper");
		System.out.println("3 - Scissors");

		System.out.print("Inform your move: ");

		return sc.nextInt();

	}

}
