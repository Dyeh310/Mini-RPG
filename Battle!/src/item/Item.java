package item;

import player.Player;

public class Item {

	private int heal;
	private String name;
	private int damage;
	protected Item item;
	private Player player;

	public Item(int damage, int heal, String name) {
		this.heal = heal;
		this.name = name;
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return getName() + ": Heals for " + getHeal(); //heals for will eventually have to be changed
	}
	
	public Item getItem(){
		return null;
	}

	public int amountHealed() {
		int healed = 0;
		
		healed = (player.getMaxHealth() - player.getHealth());
		if (healed >= item.getHeal()) {
			healed = item.getHeal();
		}
		return healed;
	}

}
