package wsmt;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

import wsmt.bursa.Apple;
import wsmt.bursa.Google;
import wsmt.bursa.IBursa;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class ExecHessClient {
	public ExecHessClient(String url) throws MalformedURLException {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setHessian2Request(true);
		
		IBursa basic = (IBursa) factory.create(IBursa.class, url);
		
		System.out.println(basic.cumpara(new Apple(), 5));
		System.out.println(basic.cumpara(new Google(), 3));
		System.out.println(basic.vinde(new Google(), 1));
		System.out.println(basic.statistica());
	}
	
	public static void main(String[] args) throws MalformedURLException {
		if (args.length > 0)
			new ExecHessClient(args[0]); //http://localhost:80/ExecHessServ.php
		else
			new ExecHessClient("http://localhost:8081/bursa");
	}
}
