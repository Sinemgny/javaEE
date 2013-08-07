package code;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import source_code_client.MyCalculator;

public class Quadrat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyCalculator calc = lookupCalculator();
		
		System.out.println(calc.getSquare(2));
		
	}

	private static MyCalculator lookupCalculator() {
		try {
			String appName = "jeep_imjl11_u5a2";
			String moduleName = "jeep_imjl11_u5a2EJB";
			String beanName = "MyCalculatorBean";
			String viewClassName = MyCalculator.class.getName();
			String lookupURL = "ejb:" + appName + "/" + moduleName + "/" + beanName 
					+ "!" + viewClassName;
		
			Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put("jboss.naming.client.ejb.context", String.valueOf(true));
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			Context context = new InitialContext(jndiProperties);
			return (MyCalculator) context.lookup(lookupURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
