package canteen;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> menuItems;
	
	public Menu(ArrayList<Item> m) {
		this.menuItems = m;
	}
	
	//Used to provide CustomerInterface with the currently available menu items
	public Item[] getItems() {
		Item[] items = new Item[menuItems.size()];
		for(int i = 0; i < menuItems.size(); i++) {
			items[i] = menuItems.get(i);
		}
		return items;
	}
	
	public void addItem(Item i) {
		this.menuItems.add(i);
	}
	
	public void removeItem(Item i) {
		this.menuItems.remove(i);
	}
}
