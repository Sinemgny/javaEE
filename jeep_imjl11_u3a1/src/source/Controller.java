package source;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import de.thm.mni.pdf.CustomerListPDF;

/**
 * Servlet implementation class Controller
 */
@WebServlet({"/Controller", "/Controller/clist.pdf"})
public class Controller extends HttpServlet {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		String forwardToView = action + ".jsp";

		if ("customer-list".equalsIgnoreCase(action)) {
			forwardToView = "/customer-list.jsp";

		}else if ("customer-edit".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				CustomerList cl = (CustomerList) getServletContext().getAttribute("list");
				Customer c = cl.get(id);
				c.count--;
				request.setAttribute("customer", c);
			} catch (Exception e) {
				e.printStackTrace();
			}
			forwardToView = "/customer-form.jsp";
		}else if ("customer-delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				CustomerList cl = (CustomerList) getServletContext().getAttribute("list");
				//				Customer c = (Customer)cl.get(id);
				cl.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			forwardToView = "/customer-list.jsp";
		}else if ("customer-list-pdf".equalsIgnoreCase(action)){
			try {
				List<String []> tableRows = new ArrayList<String []>();
				CustomerList cl = (CustomerList) getServletContext().getAttribute("list");
				for (Entry<Integer, Customer> entry : cl.getMap().entrySet()) {
					tableRows.add(new String[]{String.valueOf(entry.getKey()), String.valueOf(entry.getValue().getName()),String.valueOf(entry.getValue().getFirstName()),String.valueOf(entry.getValue().getEmail())});
				}
				byte [] pdfData = CustomerListPDF.createPDF(tableRows);
				response.setContentType("application/pdf");
				response.getOutputStream().write(pdfData);
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("customer-form".equalsIgnoreCase(action)) {
			// replacement for <jsp:useBean>

			Customer c = new Customer();

			try {

				BeanUtils.populate(c, request.getParameterMap());
				request.setAttribute("customer", c);

			} catch (IllegalAccessException | InvocationTargetException e) {

				e.printStackTrace();
			}

			request.setAttribute("customer", c);


			if ("save".equals(request.getParameter("subaction"))) {
				// validate customer object

				Map<String, String> errorMsgs = c.validate();

				request.setAttribute("errorMsgs", errorMsgs);

				if (errorMsgs.isEmpty()) {
					// persist customer
					CustomerList cl = (CustomerList) getServletContext().getAttribute("list");
					cl.add(c);
					// go to customer list
					forwardToView = "/customer-list.jsp";
				}
			}

		} else if ("customer-list".equalsIgnoreCase(action)) {
			forwardToView = "/customer-list.jsp";

		} else {
			// help
			forwardToView = "/customer-help.jsp";
		}

		// forward to view


		try {
			request.getRequestDispatcher(forwardToView).forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}


