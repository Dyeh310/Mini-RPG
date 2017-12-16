package player;

public class Player {

	private int health;
	private String name;
	private int maxHealth;
	private int physicalAttack;

	public Player(int health, String name, int physicalAttack) {
		this.maxHealth = health;
		this.health = health;
		this.name = name;
		this.physicalAttack = physicalAttack;
	}

	
	
	public int getMaxHealth() {
		return maxHealth;
	}



	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}



	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		if (this.health > this.maxHealth) {
			this.health = this.maxHealth;
		}
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
		return getName() + " HP:" + getHealth() + "/" + getMaxHealth() +  " Attack:" + getPhysicalAttack();
	}

	public void attackOptions() {
			// TODO make more options
			System.out.println("1) Attack \n3) Item \n4) Stats");
	}
	

	public String printItems() {
		
		return "Potion";
	}

}
