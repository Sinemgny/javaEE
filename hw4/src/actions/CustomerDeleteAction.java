package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import source.Action;

public class CustomerDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		/*
		 * DON'T FORGET TO CHANGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				CustomerDAO customerDAO = new CustomerDAO();
				customerDAO.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		return "customer-list.jsp";
	}

}
