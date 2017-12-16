package operations;

import item.Item;
import item.ItemList;

public class Test {

	public static void main(String[] args) {
		
		ItemList items = new ItemList();
		items.generateList();
		
		System.out.println(items.getSize());
		
	}

}
