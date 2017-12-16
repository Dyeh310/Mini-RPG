package operations;

import java.util.Scanner;

import enemy.Enemy;
import player.Player;

public class Interface {

	private Logic logic = new Logic();
	private Scanner reader = new Scanner(System.in);;
	// Player is given from Logic
	private Player player;
	private Enemy enemy;

	// CONSTRUCTOR
	public Interface() {
	}

	public void start() {

		// Character creation
		player = logic.characterCreation();
		System.out.println(player + "\n");

		// Generate Enemy
		enemy = logic.enemyCreation();
		System.out.println(enemy.getName() + " has stepped into the arena! Goodluck!! \n");


		// Battle
		boolean fighting = true;
		while (fighting) {
			// TODO add speed stats
			if (player.getHealth() > 0 && enemy.getHealth() > 0) {
				logic.playerTurn();
				if(enemy.getHealth() == 0) {
					System.out.println(enemy.getName() + " has died!");
					logic.enemyDropLoot();
					enemy = logic.enemyCreation();
					//Omit bottom line when ready
					System.out.println(enemy.getName() + " has stepped into the arena! Goodluck!! \n");
				}
			}
			if (player.getHealth() > 0 && enemy.getHealth() > 0) {
				logic.enemyTurn();
				if (player.getHealth() == 0) {
					System.out.println(player.getName() + " has died! \n --GAME OVER--");
					fighting = false;
				}
			}
		}//Battle Loop ends	
	}

}
