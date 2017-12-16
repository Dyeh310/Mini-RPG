package operations;

import java.util.Random;
import java.util.Scanner;

import enemy.Enemy;
import enemy.EnemyList;
import item.Item;
import item.ItemList;
import player.Player;

public class Logic {

	private Scanner reader = new Scanner(System.in);;
	private Random random = new Random();
	// ------------PLAYER-------
	// player is created in method
	private Player player;

	// ----------ENEMY---------
	private Enemy enemy;
	private EnemyList enemies = new EnemyList();
	private Item loot;

	// ----------ITEM---------
	private Item item;
	private ItemList items = new ItemList();

	// -------------CONSTRUCTOR-----------------
	public Logic() {
		enemies.generateList();
		items.generateList();
	}

	// -----------INTERFACE-------------------
	public void enemiesDefeated() {
		System.out.println("You have defeated all the enemies!");
		System.exit(0);
	}

	// ------------PLAYER METHODS-----------------
	public Player characterCreation() {
		System.out.println("Welcome to the arena! \nWhat is your name?");
		String name = reader.nextLine();
		int health = random.nextInt(100 - 30) + 30;
		int physicalAttack = random.nextInt(15 - 10) + 10;
		player = new Player(health, name, physicalAttack);
		System.out.println("Keep player or reroll? y/n \n" + player.toString());
		String keep = reader.nextLine();

		if (!"yes".equalsIgnoreCase(keep) && !"y".equalsIgnoreCase(keep)) {
			characterCreation();
		}

		return player;

	}

	public void playerTurn() {
		// Simpley figures out what the player wants to do.
		boolean success = false;
		while (!success) {
			System.out.println("Your turn...");
			try {
				player.attackOptions();
				int turnChoice = Integer.parseInt(reader.nextLine());
				if (turnChoice == 1) {
					playerRegularAttack();
					success = true;
				} else if (turnChoice == 3) {
					useItem();
				} else if (turnChoice == 4) {
					System.out.println(player);
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter the number associated with the option! \n");
			}
		}
	}

	private void playerRegularAttack() {
		int enemyHealth = enemy.getHealth();
		enemyHealth -= player.getPhysicalAttack();
		enemy.setHealth(enemyHealth);
		if (enemy.getHealth() < 0) {
			enemy.setHealth(0);
		}
		System.out.println(player.getName() + " attacked " + enemy.getName() + " for " + player.getPhysicalAttack()
				+ " damage! \n" + enemy.getName() + " has " + enemy.getHealth() + " health left! \n");
	}

	// ------------------ITEMS-------------------

	public void useItem() {
		boolean success = false;
		while (!success) {
			try {
				if (items.isEmpty()) {
					System.out.println("You have no items in your inventory!");
					playerTurn();
				} else {
					System.out.println("Which item would you like to use?");
					System.out.println(items);
					int itemChoice = Integer.parseInt(reader.nextLine());
					if (!items.containsKey(itemChoice)) {
						System.out.println("Item not found!");
						playerTurn();
					} else if (items.containsKey(itemChoice)) {
						Item item = items.getItem(itemChoice);
						player.setHealth(player.getHealth() + item.getHeal());
						System.out.println("The " + item.getName() + " healed " + player.getName() + " for" + " "
								+ item.amountHealed() + " health!!");
						// Remove below line
						System.out.println(player);
						success = true;
					} else {
						System.out.println("Something went wrong");
						playerTurn();
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter the number that corresponds to the item.");
			}
		}
	}

	// ---------------------ENEMY METHODS----------------
	public Enemy enemyCreation() {
		if (enemies.isEmpty()) {
			enemiesDefeated(); //This needs to be updated eventually since it still prints enemy
		} else {
			this.enemy = enemies.getRandomEnemy();
		}
		return enemy;
	}

	public void enemyTurn() {
		// If the enemy is a spellcaster, use if statement regarding mana.
		int turnChoice = 1; // This will be a random generator
		if (turnChoice == 1) {
			enemyRegularAttack();
		}
	}

	private void enemyRegularAttack() {
		int playerHealth = player.getHealth();
		playerHealth -= enemy.getPhysicalAttack();
		player.setHealth(playerHealth);
		if (player.getHealth() < 0) {
			player.setHealth(0);
		}
		System.out.println(enemy.getName() + " attacked " + player.getName() + " for " + enemy.getPhysicalAttack()
				+ " damage! \n" + player.getName() + " has " + player.getHealth() + " left! \n");
	}


	public void enemyDropLoot() {
		loot = enemy.dropLoot();
		if (loot != null) {
			items.addItem((items.getSize()+1), loot);
			System.out.println(loot + " was added to your iventory!");
		} else {
			System.out.println("The enemy didn't dropp any loot!");
		}
	}

	/// get rid of
	public EnemyList getList() {
		return enemies;
	}

}
