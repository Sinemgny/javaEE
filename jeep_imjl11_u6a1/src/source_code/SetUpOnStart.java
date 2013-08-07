package source_code;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetUpOnStart
 */
@WebServlet(value="/SetUpOnStart", loadOnStartup=1)
public class SetUpOnStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private StatefulSessionBeanInterface scf;
	@EJB
	private StatelessSessionBeanInterface scs;

	@EJB
	private StatefulSessionBeanInterface scf1;
	@EJB
	private StatelessSessionBeanInterface scs1;
	@EJB
	private StatefulSessionBeanInterface scf2;
	@EJB
	private StatelessSessionBeanInterface scs2;
	@EJB
	private StatefulSessionBeanInterface scf3;
	@EJB
	private StatelessSessionBeanInterface scs3;
	@EJB
	private StatefulSessionBeanInterface scf4;
	@EJB
	private StatelessSessionBeanInterface scs4;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUpOnStart() {
        super();
    }
    @PostConstruct
    private void setUp() {
    	ShowBeans.setState(scf, scs);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

}
