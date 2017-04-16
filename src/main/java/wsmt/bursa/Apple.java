package wsmt.bursa;

import java.io.Serializable;

/**
 * Created by Tudor on 09-Apr-17.
 */
public class Apple extends Actiune implements Serializable {
	public static final String APPLE = "Apple.INC";
	
	public Apple() {
		super(APPLE, 56.34);
	}
}
