package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by tudor on 29/04/2017.
 */
@Service
public class CarteService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	Carte getCarte(String id) {
        return Carte.builder().author("a").id(1).title("titlu").build();
    }
	
	public ResponseEntity<String> saveCarte(Carte carte) {
		return null;
	}
	
	public List<Carte> getAllCarti() {
		return null;
	}
}
