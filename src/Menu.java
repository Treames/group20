import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> menuItems;
	
	//Used to provide CustomerInterface with the currently available menu items
	public Item[] getItems() {
		Item[] items = new Item[menuItems.size()];
		for(int i = 0; i < menuItems.size() - 1 ; i++) {
			items[i] = menuItems.get(i);
		}
		return items;
	}
}
