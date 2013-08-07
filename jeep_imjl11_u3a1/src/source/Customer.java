package source;

import java.util.HashMap;
import java.util.Map;


public class Customer {
	private int id;
	private String name;
	private String firstName;
	private String email;

	public static int count;

	public Customer(){
		this.id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> validate() {
		Map<String, String> errorMsgs = new HashMap<String, String>();
		this.id = ++count;

		if (getName() == null || getName().trim().isEmpty()) {
			errorMsgs.put("name", "Name darf nicht leer sein!");
		}
		if (getFirstName() == null || getFirstName().trim().isEmpty()) {
			errorMsgs.put("firstName", "Vorname darf nicht leer sein!");
		}
		if (getEmail() == null || getEmail().trim().isEmpty()) {
			errorMsgs.put("email", "Email darf nicht leer sein!");
		}
		
		if (!(errorMsgs.isEmpty())){
			count--;
		}
		return errorMsgs;
	}
}
