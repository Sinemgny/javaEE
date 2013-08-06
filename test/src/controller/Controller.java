package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/** */

	


	public Controller() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String actionStr = request.getParameter("action");

		System.out.println("actýon:" + actionStr);

		Action action = getActionByName(actionStr);
		if (action != null) {
			String result = action.execute(request, response);
			request.getRequestDispatcher(result).forward(request, response);
		} else {
			response.getWriter().write("No action handler found!");
		}

	}

	private String packageActions;

	@Override
	public void init() throws ServletException {
		super.init();
		packageActions = getServletConfig().getInitParameter("package-actions");
	}

	private Action getActionByName(String actionName) {
		Action action = null;
		try {

			System.out.println("forName:" + packageActions + "." + actionName);
			Class clazz = Class.forName(packageActions + "." + actionName);
			action = (Action) clazz.newInstance();
		} catch (Exception e) {
			log(String.format("Action '%s' not found!", actionName));
		}
		return action;
	}
}
