package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.Action;
import code.CustomerDAOClient;
import customer.CustomerDAO;

public class CustomerDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				CustomerDAO customerDAO = new CustomerDAOClient().getDao();
				customerDAO.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		return "customer-list.jsp";
	}

}
