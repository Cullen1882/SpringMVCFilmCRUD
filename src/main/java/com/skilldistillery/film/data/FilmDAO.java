package com.skilldistillery.film.data;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
//	Film getFilmById(int filmId);
	Film findFilmbyId(int filmId);
	

}
