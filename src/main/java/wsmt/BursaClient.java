package wsmt;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

import wsmt.bursa.IBursa;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class BursaClient {
	public BursaClient(String url) throws MalformedURLException {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setHessian2Request(true);
		
		IBursa bursa = (IBursa) factory.create(IBursa.class, url);

//		System.out.println(bursa.cumpara("apple", 5));
		System.out.println(bursa.cumpara("google", 3));
		System.out.println(bursa.vinde("apple", 1));
		System.out.println(bursa.statistica());
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// Java
		new BursaClient("http://localhost:8081/bursa");
		// PHP
		//			new BursaClient("http://localhost:8081/BursaServer.php");
	}
}
