package customer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String firstName;
	private String email;
	private String birthday;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
		
		boolean ageValid = true;
		Date valid;
		try {
			valid = new SimpleDateFormat("YYYY-MM-DD").parse(birthday);
			Calendar date = new GregorianCalendar();
			date.setTime(valid);
			System.out.println(date);
			if(date.get(Calendar.YEAR)>2100 || date.get(Calendar.YEAR)<1900 || date.get(Calendar.MONTH)<0 || date.get(Calendar.MONTH)>12 || date.get(Calendar.DATE)<0 || date.get(Calendar.DATE)>31){
				ageValid = false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean countryValid = this.country != null && !this.country.trim().isEmpty();
		
		Map<String, String> map = new HashMap<String, String>();
		if (!nameValid)
			map.put("name", "Name darf nicht Leer sein!");
		if (!fnameValid)
			map.put("firstName", "Vorname darf nicht Leer sein!");
		if (!emailValid)
			map.put("email", "email darf nicht Leer sein!");
		if (!ageValid)
			map.put("age", "YYYY-MM-DD und 2100<Jahr<1900, 12<Monat<0, 31<Tag<0");
		if (!countryValid)
			map.put("country", "Land darf nicht leer sein!");
		
		return map;
	}
}
