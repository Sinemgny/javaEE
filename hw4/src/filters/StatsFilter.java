package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import statistic.Statistik;

public class StatsFilter implements Filter {

	//private FilterConfig conf;
	private static Object lock = new Object();
	private static Statistik stats = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest rq = (HttpServletRequest) request;
		stats.setStat(rq.getHeader("user-agent"));
		request.setAttribute("stats", stats);
		chain.doFilter(request, responce);
	}

	public void init(FilterConfig conf) throws ServletException {
		synchronized (lock) {
			if (stats == null) {
				stats = new Statistik();
				stats.setOs(conf.getInitParameter("os"));
				stats.setBrowsers(conf.getInitParameter("browser"));
			}
		}
		
	}

}
