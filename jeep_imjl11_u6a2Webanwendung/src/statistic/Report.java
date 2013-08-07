package statistic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import code.CustomerDAOClient;
import customer.Customer;

public class Report {

	public Map<Integer, Integer> getAgeDistribution() {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		int age = 0;
		for (Customer cust : new CustomerDAOClient().getDao().findAll()) {

			String birthday = cust.getBirthday();

			Calendar today = new GregorianCalendar();

			Calendar birth = new GregorianCalendar();
			try {
				birth.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			age = today.get(Calendar.YEAR) - (birth.get(Calendar.YEAR) + 1);

			Integer exist = result.get(age);
			if(exist == null){
				result.put(age, 1);
			}else{
				result.put(age, exist + 1);
			}	
		}
		return result;
	}

	public Map<String, Integer> getCountryDistribution() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Customer cust : new CustomerDAOClient().getDao().findAll()) {
			String country = cust.getCountry();
			Integer exist = result.get(country);
			if(exist == null){
				result.put(country, 1);
			}else{
				result.put(country, exist + 1);
			}	
		}
		return result;
	}

}
