package wsmt.bursa;

import java.io.Serializable;

/**
 * Created by Tudor on 09-Apr-17.
 */
public abstract class Actiune implements Serializable{
	String nume;
	double price;
	
	public Actiune(String nume, double price) {
		this.nume = nume;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Actiune{" +
				       "nume='" + nume + '\'' +
				       ", price=" + price +
				       '}';
	}
}
