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
	
	//Used to provide CustomerInterface with a shallow copy of the currently available menu items
	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item i: menuItems) {
			items.add(i);
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
