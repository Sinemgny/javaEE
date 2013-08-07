package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.Action;

public class CustomerListAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	
		return "customer-list.jsp";
	}

}
