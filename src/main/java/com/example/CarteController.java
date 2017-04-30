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
	public Carte getCarteByTitle(@PathVariable("title") String carteTitle) {
		return carteService.getCarte(carteTitle);
	}
	
	@GetMapping(params = "author")
	public List<Carte> getCartiByAuthor(String author) {
		return carteService.getCartiByAuthor(author);
	}
	
	@PostMapping
	public ResponseEntity<String> saveCarte(@RequestBody Carte carte) {
		int status = carteService.saveCarte(carte);
		return ResponseEntity.status(status).build();
	}
	
}


