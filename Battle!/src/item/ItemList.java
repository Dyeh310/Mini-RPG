package item;

import java.util.HashMap;
import java.util.Map;

public class ItemList {

	private Map<Integer, Item> items;
	private int itemAmount = 1;

	public ItemList() {
		this.items = new HashMap<>();
	}


	public void generateList() {
		items.put(1, new Potion());
		items.put(2, new Potion());
	}

	public boolean isEmpty() {
		if (items.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Item getItem(int itemChoice) {
		for (Integer i : items.keySet()) {
			if (i == itemChoice) {
				Item item = items.get(itemChoice);
				items.remove(itemChoice);
				return item;
			}
		}
		return null;
	}

	public boolean containsKey(int itemChoice) {
		if (items.containsKey(itemChoice)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addItem(int key, Item value) {
		
	}
	
	public int getSize() {
		return items.size();
	}

	public String toString() {
		return items.toString();
	}

}
