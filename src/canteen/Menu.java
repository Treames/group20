package canteen;

import java.util.ArrayList;

public class Menu {
	//Catalog of Menu Items
	private ArrayList<Item> menuItems;
	//List of all Interfaces dependent on the Menu
	private ArrayList<Observer> observers;
	
	/**
	 * @param m Predefinied ArrayList of items to be in menu
	 */
	public Menu(ArrayList<Item> m) {
		this.menuItems = m;
	}
	
	//Used to provide CustomerInterface with a shallow copy of the currently available menu items
	/**
	 * @return menuItems
	 */
	public ArrayList<Item> getItems() {
		return menuItems; 
	}
	
	/**
	 * @param i Item to add to menu
	 */
	public void addItem(Item i) {
		this.menuItems.add(i);
		//updateObservers();
	}
	
	/**
	 * @param i Item to remove from menu
	 */
	public void removeItem(Item i) {
		this.menuItems.remove(i);
		//updateObservers();
	}
	
	
//	public void updateObservers(){
//		for(Observer o: observers) {
//			o.update(this);
//		}
//	}
//	
//	public void addObserver(Observer o) {
//		observers.add(o);
//	}
//	
//	public void removeOberver(Observer o) {
//		observers.remove(o);
//	}
}
