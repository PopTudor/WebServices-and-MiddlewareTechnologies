package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Tema5Application {
	private static final Logger log = LoggerFactory.getLogger(Tema5Application.class);
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Tema5Application.class, args);
	}
//
//	@PostConstruct
//	public void insertData() {
//		ddlSetup();
//		List<Carte> list = Arrays.asList(
//				Carte.builder()
//						.author("Ion Creanga")
//						.title("La scaldat")
//						.pret(11.4)
//						.build(),
//				Carte.builder()
//						.author("George Cosbuc")
//						.title("Nunta Zamfirei")
//						.pret(13.0)
//						.build(),
//				Carte.builder()
//						.author("Ion Creanga")
//						.title("Capra cu trei iezi")
//						.pret(11.8)
//						.build(),
//				Carte.builder()
//						.author("Ion Luca Caragiale")
//						.title("O noapte furtunoasa")
//						.pret(14.0)
//						.build(),
//				Carte.builder()
//						.author("Ion Creanga")
//						.title("Povestea lui Harap Alb")
//						.pret(15.6)
//						.build()
//		);
//		list.forEach(carte1 -> {
//			jdbcTemplate.update("INSERT  INTO  carti(author,title, pret) VALUES (?,?,?)",
//					carte1.getAuthor(),
//					carte1.getTitle(),
//					carte1.getPret());
//		});
//	}
	
	//	@PostConstruct
//	public void insertTestData() {
//		try (Connection connection = dataSource.getConnection()) {
//			ddlSetup(connection);
//			CarteContract carte = CarteContract.builder().author("me").title("tree").build();
//			// Split up the array of whole names into an array of first/last names
//			for (CarteContract carte1 : Arrays.asList(carte)) {
//				PreparedStatement statement1 = connection.prepareStatement(
//						"INSERT INTO carti(title,author) VALUES (?,?)",
//						new String[]{"title", "author"});
//				statement1.setString(2, carte1.author);
//				statement1.setString(1, carte1.title);
//				statement1.execute();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
	private void ddlSetup(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute("DROP TABLE IF EXISTS carti");
			statement.execute("CREATE TABLE carti(" +
					"id INTEGER PRIMARY KEY , " +
					"author VARCHAR(255), " +
					"title VARCHAR(255), " +
					"pret DOUBLE" +
					")");
		}
	}
	
	private void ddlSetup() {
		jdbcTemplate.execute("DROP TABLE IF EXISTS carti");
		jdbcTemplate.execute("CREATE TABLE carti(" +
				"id INTEGER PRIMARY KEY ," +
				"author VARCHAR(255)," +
				"title VARCHAR(255)," +
				"pret DOUBLE" +
				")");
	}
	
}
