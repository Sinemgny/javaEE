package actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import source.Action;
import customer.Customer;
import customer.CustomerDAO;

public class CustomerFormAction implements Action {
	private static final String SAVE = "save";
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		boolean update = false;
		Customer c = new Customer();
		try {
			BeanUtils.populate(c, req.getParameterMap());
			req.setAttribute("customer", c);
			if (SAVE.equals(req.getParameter("subaction"))) {
				update = c.getId() != -1;
				Map<String, String> errorMsgs = c.validate();
				req.setAttribute("errorMsgs", errorMsgs);
				if (errorMsgs.isEmpty()) {
					CustomerDAO customerDAO = new CustomerDAO();
					if (update) {
						customerDAO.update(c);
					} else {
						c.setId(customerDAO.save(c));
					}
					return "customer-list.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer-form.jsp";
	}

}
