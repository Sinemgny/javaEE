package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NoAccess implements Filter {

private String[] allowedBrowser;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String userAgent = ((HttpServletRequest) req).getHeader("user-agent");
		boolean access = false;
		for (String b : allowedBrowser) {
			if (userAgent.contains(b)) {
				access = true;
				break;
			}
		}
		if (!access) {
			req.getRequestDispatcher("no_access.jsp").forward(req, resp);
			return;
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		allowedBrowser = conf.getInitParameter("allowedBrowsers").trim().split(",");
	}

}
