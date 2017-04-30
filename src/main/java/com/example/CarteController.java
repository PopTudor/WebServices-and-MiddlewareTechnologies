package com.example;

import com.example.database.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tudor on 29/04/2017.
 */
@RestController
@RequestMapping("/carti")
public class CarteController {
	@Autowired
	CarteService carteService;
	
	@GetMapping
	public List<Carte> getAllCarti() {
		return carteService.getAllCarti();
	}
	
	@GetMapping("/{title}")
	public Carte carti(@PathVariable("title") String carteTitle) {
		return carteService.getCarte(carteTitle);
	}
	
	@GetMapping(params = "author")
	public List<Carte> cartiByAuthor(String author) {
		return carteService.getCartiByAuthor(author);
	}
	
	@PostMapping
	public ResponseEntity<String> saveCarte(@RequestBody Carte carte) {
		return carteService.saveCarte(carte);
	}
}



