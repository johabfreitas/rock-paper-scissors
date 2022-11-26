package application;

import java.util.Scanner;

import entities.JoKenPo;
import entities.Player;

public class App {

	public static void main(String[] args) {
		
		JoKenPo jokenpo = startGame();
		jokenpo.toPlay();
	}

	@SuppressWarnings("resource")
	public static JoKenPo startGame() {
		System.out.println("******** Jo-Ken-Po ********\n");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String playerName = sc.next().toUpperCase();

		Player user = new Player(playerName);

		Player IA = new Player("IA");

		System.out.print(playerName + ", enter how many rounds you want to play: ");
		int rounds = sc.nextInt();
		
		return new JoKenPo(user, IA, rounds);
	}

}
