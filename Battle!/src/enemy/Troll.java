package enemy;

import item.Item;
import item.Potion;

public class Troll extends Enemy {
	
	protected Potion potion;

	public Troll(int health, String name, int physicalAttack) {
		super(health, name, physicalAttack);

	}

	@Override
	public Item dropLoot() {
		if (random.nextInt(2) == 1) {
			potion = new Potion();
			return potion;
		} else {
			return null;
		}
	}
	
	
	

	
}
