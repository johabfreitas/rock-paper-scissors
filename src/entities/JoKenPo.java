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
				continue;
			}
			
			int choiceia = choiceIA();
			
			System.out.println("\n" + user.getName() + " " + choiceuser + " X " + choiceia + " " + IA.getName());
			
			int result = choiceuser - choiceia;
			
			winnerRound(result);
		}
	}
	
	public void showFinalResult() {
		System.out.println("\n**************************************\n");
		
		Integer finalScoreUser = user.getScore();
		Integer finalScoreIA = IA.getScore();
		
		System.out.println("\n\tFINAL SCORE: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());
		
		if(finalScoreUser == finalScoreIA) {
			System.out.println("\t\t\tDRAW!");
		} else {
			String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
			
			System.out.println("\t\tWINNER = " + finalWinner.toUpperCase());
		}
		
		System.out.println("\n**************************************\n");
	}
	
	private void winnerRound(int result) {
		String winnerRound;
		if(result == 0) {
			winnerRound = "DRAW!";
		} else {
			if(result == -1 || result == 2) {
				IA().incrementScore();
				winnerRound = IA().getName();
			} else {
				user.incrementScore();
				winnerRound = user().getName();
			}
		}
		System.out.println("\nWinner Round: " + winnerRound + "\n");
	}
	
	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(1, 4);
	}
	
	@SuppressWarnings("resource")
	private int choiceUser() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1 - Rock");
		System.out.println("2 - Paper");
		System.out.println("3 - Scissors");

		System.out.print("Inform your move: ");

		return sc.nextInt();

	}

}
