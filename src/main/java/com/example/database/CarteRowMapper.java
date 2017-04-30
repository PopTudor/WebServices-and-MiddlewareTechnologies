package com.example.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tudor on 30/04/2017.
 */
public class CarteRowMapper implements RowMapper<Carte> {
	
	@Override
	public Carte mapRow(ResultSet rs, int rowNum) throws SQLException {
		int index = rs.findColumn(CarteContract.id);
		int author = rs.findColumn(CarteContract.author);
		int title = rs.findColumn(CarteContract.title);
		int pret = rs.findColumn(CarteContract.pret);
		return Carte.builder()
				.id(rs.getInt(index))
				.author(rs.getString(author))
				.title(rs.getString(title))
				.pret(rs.getDouble(pret))
				.build();
	}
}
