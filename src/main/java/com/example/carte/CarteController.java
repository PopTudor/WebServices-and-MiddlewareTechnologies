package com.example.carte;

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
		return carteService.getCarteByTitle(carteTitle);
	}
	
	@GetMapping("/title/{sort}")
	public List<Carte> getCartiSortByTitle(@PathVariable("sort") String sort) {
		return carteService.getCartiSortByTitle(sort);
	}
	
	@GetMapping(params = "author")
	public List<Carte> getCartiByAuthor(String author) {
		return carteService.getCartiByAuthor(author);
	}
	
	@PostMapping
	public ResponseEntity<Integer> saveCarte(@RequestBody Carte carte) {
		int status = carteService.saveCarte(carte);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping("{title}")
	public ResponseEntity<String> updateCarte(@PathVariable("title") String title, @RequestBody Carte carte) {
		int status = carteService.update(title, carte);
		return ResponseEntity.ok(String.valueOf(status));
	}
}


