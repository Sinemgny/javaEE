package customer;

import java.util.List;

import javax.ejb.Local;
@Local
public interface CustomerDAO {
	int save (Customer c);
	void update (Customer c);
	Customer findById (int id);
	List<Customer> findAll();
	void delete (int id);
}
