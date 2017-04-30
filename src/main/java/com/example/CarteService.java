package com.example;

import com.example.database.Carte;
import com.example.database.CarteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tudor on 29/04/2017.
 */
@Service
public class CarteService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Carte getCarteByTitle(String title) {
		String[] strings = new String[]{title};
		return jdbcTemplate.queryForObject("SELECT * FROM carti WHERE title = ?", strings, new CarteRowMapper());
	}
	
	List<Carte> getCartiByAuthor(String... author) {
		return jdbcTemplate.query("SELECT * FROM carti WHERE author LIKE ?", author, new CarteRowMapper());
	}
	
	public int saveCarte(Carte carte) {
		PreparedStatementSetter setter = new ArgumentPreparedStatementSetter(
				new Object[]{carte.getAuthor(), carte.getTitle(), carte.getPret()});
		return jdbcTemplate.update("INSERT INTO carti(author,title, pret) VALUES (?,?,?)", setter);
	}
	
	public List<Carte> getAllCarti() {
		return jdbcTemplate.query("SELECT * FROM carti", new BeanPropertyRowMapper<>(Carte.class));
	}
	
	public List<Carte> getCartiSortByTitle(String sort) {
		return jdbcTemplate.query("SELECT * FROM carti ORDER BY title " + sort,
				new BeanPropertyRowMapper<>(Carte.class));
	}
}