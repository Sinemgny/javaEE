package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import de.thm.mni.dao.CustomerDAO;
import de.thm.mni.jeep.Customer;







public  class CustomerFormAction implements Action {
@Override
public String execute(HttpServletRequest request, HttpServletResponse resp) {
	String forwardToView = "/customer-form.jsp";
	
	//edit case
	if(request.getParameter("id")!=null){
		if( Integer.parseInt(request.getParameter("id")) >=0 ){
			int id = -1;
		//	Customer c = null;
			/*try {
	//ask	//		BeanUtils.populate(c, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}*/
			
/*			new CustomerDAO().update(c);
			request.setAttribute("customer", c);
		}  */
			
			CustomerDAO cdao = lookupDAO();
			List<Customer> customerMap = cdao.findAll();
			//Map<Integer,Customer> customerMap = (Map<Integer, Customer>) req.getServletContext().getAttribute("cmap");
			Customer c = customerMap.get(id);
			cdao.update(c);
			//req.setAttribute("customer", c);
		}
	}
	
	
return forwardToView;
}

private static CustomerDAO lookupDAO() {
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