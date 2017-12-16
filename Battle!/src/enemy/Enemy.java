package enemy;

import java.util.Random;

import item.Item;
import item.Potion;

public class Enemy {

	private int health;
	private String name;
	private int physicalAttack;
	protected Item loot;
	protected Random random = new Random();
	
	public Enemy(int health, String name, int physicalAttack) {
		this.health = health;
		this.name = name;
		this.physicalAttack = physicalAttack;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysicalAttack() {
		return physicalAttack;
	}

	public void setPhysicalAttack(int physicalAttack) {
		this.physicalAttack = physicalAttack;
	}
	
	public String toString() {
		return getName() + " HP:" + getHealth() + " Attack:" + getPhysicalAttack();
	}
	
	public Item dropLoot () {
		loot = new Potion();
		return loot;
	}
	
	
}
