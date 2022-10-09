package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
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
				film.setCast(findActorsByFilmId(filmId));
//			
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
//		List<Film> film = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE actor.id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				actor = new Actor();

				actor.setaId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actor.setDisco(findFilmsByActorId(actorId));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> filmCast = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name, film.title FROM actor JOIN film_actor ON actor_id = actor.id JOIN film ON film_id = film.id WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();

				actor.setaId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				filmCast.add(actor);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmCast;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> filmList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SSELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id JOIN actor ON actor.id = film_actor.actor_id JOIN language ON film.language_id = language.id  WHERE actor.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();

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
				filmList.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

	@Override
	public List<Film> findFilmByKeyword(String key) {
		List<Film> keyFilms = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + key + "%");
			stmt.setString(2, "%" + key + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();

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
				film.setCast(findActorsByFilmId(rs.getInt("id")));
				keyFilms.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keyFilms;
	}

	@Override
	public Film createFilm(Film film) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO film (title, description, release_year, rating, language_id) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getRelYear());
			stmt.setString(4, film.getRating());
			stmt.setInt(5, film.getLangId());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					film.setId(rs.getInt(1));
				}
				rs.close();
			}
			conn.commit();
			stmt.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			film = null;
		}
		return film;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		boolean deleted = false;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM film WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				deleted = true;
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return deleted;

	}

	@Override
	public Film updateFilm(Film film, int filmId) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String sql = "UPDATE film SET title=?, description=?, release_year=?, rating=?, language_id=? WHERE film.id =?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getRelYear());
			stmt.setString(4, film.getRating());
			stmt.setInt(5, film.getLangId());
			stmt.setInt(6, filmId);

			int updateCount = stmt.executeUpdate();
			
			conn.commit();
			
			film = findFilmById(filmId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;

	}

}