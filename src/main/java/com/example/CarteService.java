package com.example;

import com.example.database.Carte;
import com.example.database.CarteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tudor on 29/04/2017.
 */
@Service
public class CarteService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Carte getCarte(String... title) {
		return jdbcTemplate.queryForObject("SELECT * FROM carti WHERE title = ?", title, new CarteRowMapper());
	}
	
	public ResponseEntity<String> saveCarte(Carte carte) {
		return null;
	}
	
	public List<Carte> getAllCarti() {
		return jdbcTemplate.query("SELECT * FROM carti", new BeanPropertyRowMapper<>(Carte.class));
	}
}
