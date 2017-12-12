package operations;

import item.Item;
import item.ItemList;

public class Test {

	public static void main(String[] args) {
		
		ItemList items = new ItemList();
		items.generateList();
		
		System.out.println(items);
		
		if (items.containsKey(1)) {
			Item item = items.getItem(1);
			System.out.println(item);
		} else {
			System.out.println("False");
		}
		
	}

}
