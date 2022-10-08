package com.skilldistillery.film.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDaoJdbcImpl;
import com.skilldistillery.film.entities.Film;

@Controller 
public class FilmController {
	@Autowired
	private FilmDaoJdbcImpl dao;

	public void setFilmDao(FilmDaoJdbcImpl filmDao) {
		this.dao = filmDao;
	}
	
	@RequestMapping(path="showFilm.do", method= RequestMethod.GET)
	public ModelAndView showFilmById(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", dao.findFilmById(filmId));
	
		mv.setViewName("FilmDetail");
		return mv;
	}
	
	@RequestMapping(path="showFilms.do", method= RequestMethod.GET)
	public ModelAndView showFilmBySearch(@RequestParam("keyword") String key) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("films", dao.findFilmByKeyword(key));
		mv.setViewName("FilmsDetail");
		return mv;
	}
	@RequestMapping(path="addFilm.do", method= RequestMethod.POST)
	public ModelAndView addFilms(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		dao.createFilm(film);
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmAdded.do");
		return mv;
	}
	
	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FilmDetail");
		return mv;

	}
	
	@RequestMapping(path="removeFilm.do", method = RequestMethod.POST)
	public ModelAndView removeFilm(int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		dao.deleteFilm(filmId);
		redir.addFlashAttribute("rmvFilm", filmId);
		mv.setViewName("redirect:filmRemoved.do");
		return mv;
	}
	
	@RequestMapping(path="filmRemoved.do", method = RequestMethod.GET)
	public ModelAndView filmRemoved() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FilmRemoved");
		return mv;
	}
	
	

}

