package customer;

import java.util.HashMap;
import java.util.Map;

public class Customer {
	private int id;
	private String name;
	private String firstName;
	private String email;
	private int age;
	private String country;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> validate() {
		boolean nameValid = this.name != null && !this.name.trim().isEmpty();
		boolean fnameValid = this.firstName != null && !this.firstName.trim().isEmpty();
		boolean emailValid = this.email != null && !this.email.trim().isEmpty();
		boolean ageValid = this.age > 0 && this.age < 150;
		boolean countryValid = this.country != null && !this.country.trim().isEmpty();
		
		Map<String, String> map = new HashMap<String, String>();
		if (!nameValid)
			map.put("name", "Name darf nicht Leer sein!");
		if (!fnameValid)
			map.put("firstName", "Vorname darf nicht Leer sein!");
		if (!emailValid)
			map.put("email", "email darf nicht Leer sein!");
		if (!ageValid)
			map.put("age", "kein gültiges alter angegeben!");
		if (!countryValid)
			map.put("country", "Land darf nicht leer sein!");
		
		return map;
	}
}
