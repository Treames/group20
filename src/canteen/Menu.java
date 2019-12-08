package canteen;

import java.util.ArrayList;

public class Menu {
	//Catalog of Menue Items
	private ArrayList<Item> menuItems;
	//List of all Interfaces dependent on the Menu
	private ArrayList<Observer> observers;
	
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
		updateObservers();

	}
	
	public void removeItem(Item i) {
		this.menuItems.remove(i);
		updateObservers();
	}
	
	
	public void updateObservers(){
		for(Observer o: observers) {
			o.update(this);
		}
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeOberver(Observer o) {
		observers.remove(o);
	}
}
