package enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyList {

	private List<Enemy> enemies;
	private Random random;

	public EnemyList() {
		this.random = new Random();
		this.enemies = new ArrayList<>();
	}

	public Enemy getRandomEnemy() {
		int index = random.nextInt(enemies.size());
		Enemy enemy = enemies.get(index);
		enemies.remove(enemies.get(index));
		return enemy;
	}

	public String toString() {
		return enemies.toString();
	}

	
	public void generateList() {
		enemies.add(new Goblin(random.nextInt(30 - 20) + 20, "Goblin", random.nextInt(20 - 10) + 10));
		enemies.add(new Troll(random.nextInt(40 - 25) + 20, "Troll", random.nextInt(30 - 10) + 10));
	}

	public int getSize() {
		return enemies.size();
	}
}
