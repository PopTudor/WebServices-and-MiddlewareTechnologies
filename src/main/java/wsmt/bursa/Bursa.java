package wsmt.bursa;

import com.caucho.hessian.server.HessianServlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class Bursa extends HessianServlet implements IBursa {
	private final List<Actiune> actiuni = new Vector<>();
	
	public Bursa() {
	}
	
	@Override
	public String cumpara(Actiune actiune, int numarActiuni) {
		List<Actiune> actiunes = new ArrayList<>(numarActiuni);
		for (int i = 0; i < numarActiuni; i++)
			actiunes.add(actiune);
		actiuni.addAll(actiunes);
		return String.format("Ai cumparat %d actiuni in valoare de %s", actiunes.size(), calculeazaValoare(actiunes));
	}
	
	@Override
	public String vinde(Actiune actiuneUser, int numarActiuni) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < actiuni.size() && count < numarActiuni; i++) {
			if (actiuni.get(i).nume.equals(actiuneUser.nume)) {
				sum += actiuni.get(i).price;
				actiuni.remove(i);
				count++;
			}
		}
		return String.format("Ai vandut %d actiuni in valoare de %s$", count, sum);
	}
	
	@Override
	public String statistica() {
		return "Status: " + actiuni.toString();
	}
	
	private double calculeazaValoare(List<Actiune> actiunes) {
		double sum = 0;
		for (Actiune it : actiunes) sum += it.price;
		return sum;
	}
}
