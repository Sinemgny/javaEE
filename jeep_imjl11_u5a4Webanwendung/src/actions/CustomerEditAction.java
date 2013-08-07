package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.Action;
import code.CustomerDAOClient;
import customer.Customer;
import customer.CustomerDAO;

public class CustomerEditAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			CustomerDAO customerDAO = new CustomerDAOClient().getDao();
			Customer customer = customerDAO.findById(id);
			req.setAttribute("customer", customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer-form.jsp";
	}

}
