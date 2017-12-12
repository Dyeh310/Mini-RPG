package item;

public class Item {

	private int heal;
	private String name;
	private int value;

	public Item(int value, int heal, String name) {
		this.value = value;
		this.heal = heal;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
		return getName() + ": Heals for " + getHeal();
	}

	public void useItem() {
		//heal player
	}

}
