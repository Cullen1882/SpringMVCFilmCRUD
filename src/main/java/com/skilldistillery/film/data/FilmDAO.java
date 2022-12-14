package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmsByActorId(int actorId);
	  public List<Film> findFilmByKeyword(String key);
	  public Film createFilm(Film film);
	  public boolean deleteFilm(int filmId);
	  public Film updateFilm(Film film, int filmId);
}
