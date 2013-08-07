package source;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.CustomerHelpAction;

/**
 * Servlet implementation class Controller
 */
@WebServlet({"/Controller", "/Controller/clist.pdf"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 5078407017693156049L;
	private static final String ACTION = "action";
	private static final String ERROR_MSG = "No action handler found!";
	
	private String packageActions;
	private String defaultAction;
	
	@Override
	public void init() throws ServletException {
		super.init();
		packageActions = getServletConfig().getInitParameter("package-actions");
		defaultAction = getServletConfig().getInitParameter("default-action");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String actionValue = req.getParameter(ACTION);
		
		Action action = getActionForName(actionValue);
		
		if (action == null) {
			action = getActionForName(defaultAction);
		}
		if (action != null) {
			String result = action.execute(req, resp);
			if (!result.equals("stay")) {
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} else {
			resp.getWriter().write(ERROR_MSG);
		}
	}

	private Action getActionForName(String actionName) {
		Action action = null;
		Action help = new CustomerHelpAction();
		String name = "actions" + '.' + actionName;
		try {
			Class<?> clazz = Class.forName(name);
			action = (Action) clazz.newInstance();
		} catch (Exception e) {
			log(String.format("Action '%s' not found!", name));
			action = help;
		}
		return action;
	}
}

