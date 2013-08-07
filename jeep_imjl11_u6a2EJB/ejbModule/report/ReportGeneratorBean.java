package report;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import customer.Customer;
import customer.CustomerDAO;
import customer.CustomerDAOBean;

@Stateless
public class ReportGeneratorBean implements ReportGenerator {

	@Resource(mappedName = "java:jboss/mail/thm")
	javax.mail.Session mailSession;

	@EJB
	CustomerDAO customerDAOBean;
	
	@Schedule(hour = "*", minute = "*/1")
	public void sendReportMail() {
		StringBuilder msg = new StringBuilder();
		msg.append("Age distribution:\n");
		Map<Integer, Integer> ageDist = getAgeDistribution();
		
		for (Integer key : ageDist.keySet()) {
			msg.append(String.format("%d : %d\n", key, ageDist.get(key)));
		}
		msg.append("Country distribution\n");
		Map<String, Integer> countryDist = getCountryDistribution();
		
		for (String key : countryDist.keySet()) {
			msg.append(String.format("%s : %d\n", key, countryDist.get(key)));
		}
		
		Message simpleMessage =  new MimeMessage(mailSession);
		try {
			simpleMessage.setFrom(new InternetAddress("ilja.michajlow@mni.thm.de"));
			simpleMessage.setRecipient(RecipientType.TO, new InternetAddress("ilja.michajlow@mni.thm.de"));
			simpleMessage.setSubject("Customer report");
			simpleMessage.setText(msg.toString());
			Transport.send(simpleMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, Integer> getAgeDistribution() {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		int age = 0;
		for (Customer cust : new CustomerDAOBean().findAll()) {

			String birthday = cust.getBirthday();

			Calendar today = new GregorianCalendar();

			Calendar birth = new GregorianCalendar();
			try {
				birth.setTime(new SimpleDateFormat("YYYY-MM-DD").parse(birthday));
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
		for (Customer cust : new CustomerDAOBean().findAll()) {
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
