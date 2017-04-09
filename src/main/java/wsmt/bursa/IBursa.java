package wsmt.bursa;

/**
 * Created by Tudor on 09-Apr-17.
 */
public interface IBursa {
	String cumpara(Actiune actiune, int numarActiuni);
	
	String vinde(Actiune actiuneUser, int numarActiuni);
	
	String statistica();
}
