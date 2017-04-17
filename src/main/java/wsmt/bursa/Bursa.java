package wsmt.bursa;

import com.caucho.hessian.server.HessianServlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class Bursa extends HessianServlet implements IBursa {
	private final List<Actiune> actiuni;
	
	public Bursa() {
		actiuni = getActiuniFromFile();
	}
	
	@Override
	public String cumpara(String actiune, int numarActiuni) {
		List<Actiune> actiunes = new ArrayList<>(numarActiuni);
		for (int i = 0; i < numarActiuni; i++)
			actiunes.add(createActiune(actiune));
		actiuni.addAll(actiunes);
		saveActiuniToFile(actiuni);
		return String.format("Ai cumparat %d actiuni in valoare de %s", actiunes.size(), calculeazaValoare(actiunes));
	}
	
	@Override
	public String vinde(String actiuneUser, int numarActiuni) {
		double sum = 0.0;
		int count = 0;
		for (int i = 0; i < actiuni.size() && count < numarActiuni; i++) {
			Actiune actiune = actiuni.get(i);
			if (actiune.nume.equalsIgnoreCase(actiuneUser)) {
				sum += actiuni.get(i).price;
				actiuni.remove(i);
				count++;
			}
		}
		saveActiuniToFile(actiuni);
		return String.format("Ai vandut %d actiuni in valoare de %s$", count, sum);
	}
	
	@Override
	public String statistica() {
		String result = "********* Status *********\n" ;
		result+="Numar actiuni: "+actiuni.size()+"\n";
		result += "Actiuni: " + actiuni.toString();
		return result;
	}
	
	private double calculeazaValoare(List<Actiune> actiunes) {
		double sum = 0;
		for (Actiune it : actiunes) sum += it.price;
		return sum;
	}
	
	public static Actiune createActiune(String companie) {
		if (companie.equalsIgnoreCase(Apple.APPLE))
			return new Apple();
		else if (companie.equalsIgnoreCase(Google.GOOGLE))
			return new Google();
		else
			return new EmptyActiune();
	}
	
	List<Actiune> getActiuniFromFile() {
		List<Actiune> actiunes = new Vector<>();
		try (ObjectInputStream inputStream =
				     new ObjectInputStream(new FileInputStream("ar.txt"))) {
			actiunes = (List<Actiune>) inputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return actiunes;
	}
	
	void saveActiuniToFile(List<Actiune> actiunes) {
		try (ObjectOutputStream stream =
				     new ObjectOutputStream(new FileOutputStream("ar.txt"))) {
			stream.writeObject(actiunes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
