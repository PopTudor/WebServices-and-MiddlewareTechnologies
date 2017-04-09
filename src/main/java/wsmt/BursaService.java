package wsmt;

import com.caucho.hessian.server.HessianServlet;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;

import javax.servlet.annotation.WebServlet;

import wsmt.bursa.Bursa;


/**
 * Created by Tudor on 30-Mar-17.
 */
@WebServlet("/exec")
public class BursaService extends HessianServlet  {
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);
		ServletHandler handler = new ServletHandler();
		server.setHandlers(new Handler[]{handler});
		handler.addServletWithMapping(Bursa.class, "/bursa");
		System.out.println("hessian server started");
		server.start();
		server.join();
	}
}
