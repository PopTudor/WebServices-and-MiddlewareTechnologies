package wsmt.bursa;

/**
 * Created by Tudor on 09-Apr-17.
 */
public interface IBursa {
	String cumpara(String actiune, int numarActiuni);
	
	String vinde(String actiuneUser, int numarActiuni);
	
	String statistica();
}
