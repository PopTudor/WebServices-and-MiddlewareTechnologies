package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by tudor on 29/04/2017.
 */
@Service
public class CarteService {

    Carte getCarte(String id) {
        return Carte.builder().author("a").id(1).title("titlu").build();
    }
	
	public ResponseEntity<String> saveCarte(Carte carte) {
		
		return null;
	}
}
