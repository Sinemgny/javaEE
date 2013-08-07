package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.Action;
import code.CustomerDAOClient;
import customer.Customer;
import customer.CustomerDAO;
import de.thm.mni.pdf.CustomerListPDF;



public class CustomerPDFAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<String []> tableRows = new ArrayList<String []>();
			CustomerDAO customerDAO = new CustomerDAOClient().getDao();
			List<Customer> customerList = customerDAO.findAll();
			for (Customer entry : customerList) {
				tableRows.add(new String[] {String.valueOf(entry.getId()), entry.getName(), entry.getFirstName(), entry.getEmail()});
			}
			byte [] pdfData = CustomerListPDF.createPDF(tableRows);
			resp.setContentType("application/pdf");
			resp.getOutputStream().write(pdfData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "stay";
	}

}
