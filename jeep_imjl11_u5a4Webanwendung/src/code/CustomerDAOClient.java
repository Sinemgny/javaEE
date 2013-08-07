package code;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import customer.CustomerDAO;


public class CustomerDAOClient {

	private CustomerDAO dao;
	
	public CustomerDAOClient() {
		try {
			String appName = "jeep_imjl11_u5a4";
			String moduleName = "jeep_imjl11_u5a4EJB";
			String beanName = "CustomerDAOBean";
			String viewClassName = CustomerDAO.class.getName();
			String lookupURL = "ejb:" + appName + "/" + moduleName + "/" + beanName 
					+ "!" + viewClassName;
			
			Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put("jboss.naming.client.ejb.context", String.valueOf(true));
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			Context context = new InitialContext(jndiProperties);
			
			dao = (CustomerDAO) context.lookup(lookupURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CustomerDAO getDao() {
		return dao;
	}
}
