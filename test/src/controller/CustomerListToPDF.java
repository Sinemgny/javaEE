package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CustomerDAOLookup;
import de.thm.mni.dao.CustomerDAO;
import de.thm.mni.jeep.Customer;
import de.thm.mni.pdf.CustomerListPDF;

public class CustomerListToPDF implements Action {
	CustomerDAO cdao = CustomerDAOLookup.lookupDAO();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse response) {
		
		List<Customer> customers = cdao.findAll();
		
		String data[][] = new String[customers.size()][6];
		for(int i=0;i<customers.size();i++){
			data[i][0] = ""+customers.get(i).getId();
			data[i][1] = customers.get(i).getName();
			data[i][2] = customers.get(i).getFirstName();
			data[i][3] = customers.get(i).getEmail();
			data[i][4] = ""+customers.get(i).getBirthday();
			data[i][5] = customers.get(i).getCountry();
		}
		List<String[]> valueList = new ArrayList<String[]>();
		
		for(int i=0;i<customers.size();i++){
			valueList.add(data[i]);
		}
		
		try {
			byte[] pdfData = CustomerListPDF.createPDF(valueList);
			response.getOutputStream().write(pdfData);
		
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
