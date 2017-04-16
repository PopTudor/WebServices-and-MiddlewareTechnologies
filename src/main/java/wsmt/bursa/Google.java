package wsmt.bursa;

import java.io.Serializable;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class Google extends Actiune implements Serializable{
	public static final String GOOGLE = "GOOGLE.INC";
	
	public Google() {
		super(GOOGLE, 56.65);
	}
}
