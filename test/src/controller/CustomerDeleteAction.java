package controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CustomerDAOLookup;

import de.thm.mni.dao.CustomerDAO;


public class CustomerDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		int id = -1;
		
		CustomerDAO cdao = CustomerDAOLookup.lookupDAO();
		if( (id = Integer.parseInt(request.getParameter("id"))) >=0 ){
			
		//	Map<Integer, Customer> cusMap = (Map<Integer, Customer>)request.getServletContext().getAttribute("cmap");
			
			/*if (cusMap == null) {
				request.getServletContext().setAttribute("cmap", new HashMap<Integer, Customer>());
				cusMap = new HashMap<Integer, Customer>();
			}*/
			
			//new CustomerDAO().Delete(id);
			cdao.delete(id);
		}
		
		return "/customer-list.jsp";
	}
	
	
	
}
