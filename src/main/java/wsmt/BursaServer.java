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
public class BursaServer extends HessianServlet  {
	public static final Integer PORT = 8081;
	public static String BURSA_ENDPOINT = "/bursa";
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		ServletHandler handler = new ServletHandler();
		server.setHandlers(new Handler[]{handler});
		handler.addServletWithMapping(Bursa.class, BURSA_ENDPOINT);
		System.out.println("hessian server started");
		server.start();
		server.join();
	}
}
