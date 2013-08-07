package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import datenbank.DBHelper;

@Stateless
public class CustomerDAOBean implements CustomerDAO {

	public static final String TABLE_NAME = "customer";
	public static final String ID = "id";
	public static final String FIRST_NAME = "first_name";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String AGE = "age";
	public static final String COUNTRY = "country";
	
	public int save(Customer c) {
		Connection con = DBHelper.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		StringBuilder updateSql = new StringBuilder();
		int newId = -1;
		
		updateSql.append(" INSERT INTO " + TABLE_NAME);
		updateSql.append(" (" + NAME);
		updateSql.append("," + FIRST_NAME);
		updateSql.append("," + EMAIL);
		updateSql.append("," + AGE);
		updateSql.append("," + COUNTRY);
		updateSql.append(") ");
		
		updateSql.append(" values (?,?,?,?,?) ");
		
		try {
			pStmt = con.prepareStatement(updateSql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, c.getName());
			pStmt.setString(2, c.getFirstName());
			pStmt.setString(3, c.getEmail());
			pStmt.setInt(4, c.getAge());
			pStmt.setString(5, c.getCountry());
			
			pStmt.execute();
			
			rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				newId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeResultSet(rs);
			DBHelper.closeStatement(pStmt);
			DBHelper.closeConnection(con);
		}
		
		return newId;
	}
	
	public void update(Customer c) {
		Connection con = DBHelper.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		StringBuilder updateSql = new StringBuilder();
		updateSql.append(" UPDATE " + TABLE_NAME);
		updateSql.append(String.format(" SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", 
				NAME, FIRST_NAME, EMAIL, AGE, COUNTRY, ID));
		
		try {
			pStmt = con.prepareStatement(updateSql.toString());
	
			pStmt.setString(1, c.getName());
			pStmt.setString(2, c.getFirstName());
			pStmt.setString(3, c.getEmail());
			pStmt.setInt(4, c.getAge());
			pStmt.setString(5, c.getCountry());
			pStmt.setInt(6, c.getId());
			
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeResultSet(rs);
			DBHelper.closeStatement(pStmt);
			DBHelper.closeConnection(con);
		}
	}
	
	public Customer findById(int id) {
		Customer customer = null;
		
		Connection con = DBHelper.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(String.format("SELECT * FROM %s WHERE %s = %d", TABLE_NAME, ID, id));
			/*
			 * Moves the cursor forward one row from its current position.
			 */
			if(rs.next()){
				customer = createFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeResultSet(rs);
			DBHelper.closeStatement(stmt);
			DBHelper.closeConnection(con);
		}
		return customer;
	}
	
	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<Customer>();


		Connection con = DBHelper.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(String.format("SELECT * FROM %s", TABLE_NAME));
			while (rs.next()) {


				list.add(createFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeResultSet(rs);
			DBHelper.closeStatement(stmt);
			DBHelper.closeConnection(con);
		}

		return list;
	}
	
	public void delete(int id) {
		Connection con = DBHelper.getConnection();
		Statement stmt = null;
		
		StringBuilder updateSql = new StringBuilder();
		updateSql.append(" DELETE FROM " + TABLE_NAME);
		updateSql.append(" WHERE " + ID + " = " + id);
		try {
			stmt = con.createStatement();
			stmt.execute(updateSql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeStatement(stmt);
			DBHelper.closeConnection(con);
		}
	}

	private Customer createFromResultSet(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt(ID));
		customer.setFirstName(rs.getString(FIRST_NAME));
		customer.setName(rs.getString(NAME));
		customer.setEmail(rs.getString(EMAIL));
		customer.setAge(rs.getInt(AGE));
		customer.setCountry(rs.getString(COUNTRY));
		return customer;
	}

}
