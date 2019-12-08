package canteen;

import java.util.ArrayList;

public class OrderProcessor {
	private ArrayList<Observer> observers;
	
	public void updateObservers(){
		for(Observer o: observers) {
			//o.update(this);
		}
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeOberver(Observer o) {
		observers.remove(o);
	}
}
