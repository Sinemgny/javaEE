package util;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import de.thm.mni.dao.CustomerDAO;

public class CustomerDAOLookup {
	public static CustomerDAO lookupDAO() {
		try {
			String appName = "CustomerEAR";
			String moduleName = "CustomerEJB";
			String beanName = "CustomerDAOBean";
			String viewClassName = CustomerDAO.class.getName();
			String lookupURL = "ejb:" + appName + "/" + moduleName + "/" + beanName 
					+ "!" + viewClassName;
			// ejb:CustomerEAR/CustomerEJB/CustomerDAOBean!de.thm.mni.jeep.dao.CustomerDAO
			Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context context = new InitialContext(jndiProperties);
			return (CustomerDAO) context.lookup(lookupURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
