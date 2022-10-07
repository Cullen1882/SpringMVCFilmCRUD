package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO{
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

//	@Override
//	public Film getFilmById(int filmId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}
	@Override
	public Film findFilmbyId(int filmId) {
		Film film = null;

		String user = "student";
		String pass = "student";
		try{
			Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			film = new Film();

			film.setId(rs.getInt("id"));
			film.setTitle(rs.getString("title"));
			film.setDesc(rs.getString("description"));
			film.setRelYear(rs.getInt("release_year"));
			film.setLangId(rs.getInt("language_id"));
			film.setLang(rs.getString("name"));
			film.setRentDur(rs.getInt("rental_duration"));
			film.setRentRate(rs.getDouble("rental_rate"));
			film.setLength(rs.getInt("length"));
			film.setRepCost(rs.getDouble("replacement_cost"));
			film.setRating(rs.getString("rating"));
			film.setSpecFeat(rs.getString("special_features"));
//			film.setCast(findActorsByFilmId(filmId));
//			
		}
		rs.close();
		stmt.close();
		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return film;
	
	}
}
