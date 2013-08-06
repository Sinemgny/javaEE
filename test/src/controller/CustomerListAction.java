package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CustomerDAOLookup;

import de.thm.mni.dao.CustomerDAO;
import de.thm.mni.jeep.Customer;

public class CustomerListAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		CustomerDAO cdao = CustomerDAOLookup.lookupDAO();
		String forwardToView = "/customer-list.jsp";
		
		List<Customer> customers = cdao.findAll();

		request.getServletContext().setAttribute("customers", customers);

		return forwardToView;
	
	
		
	
	
	
	
	
	
	
	
	
	}

}
