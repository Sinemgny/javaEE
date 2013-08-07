package source;

import java.util.HashMap;
import java.util.Map;


public class CustomerList {
private Map<Integer, Customer> map;
	
	public CustomerList() {
		map = new HashMap<Integer, Customer>();
	}
	
	public void add(Customer c) {
		map.put(c.getId(), c);
	}
	
	public Map<Integer, Customer> getMap() {
		return new HashMap<Integer, Customer>(this.map);
	}

	public Customer get(int id) {
		return this.map.get(id);
	}

	public void delete(int id) {
		this.map.remove(id);	
	}
	
	
}
