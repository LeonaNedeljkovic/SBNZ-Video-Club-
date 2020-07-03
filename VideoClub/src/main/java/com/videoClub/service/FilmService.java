package com.videoClub.service;

import java.util.List;

import com.videoClub.dto.FilmDTO;
import com.videoClub.dto.MessageDto;
import com.videoClub.model.Film;
import com.videoClub.model.RegisteredUser;
import com.videoClub.model.User;
import com.videoClub.model.drl.RecommendedFilm;
import com.videoClub.model.enumeration.Genre;

public interface FilmService {

	public MessageDto save(FilmDTO filmDTO);
	public Film getOne(Long id);
	public List<Film> getAll();
	public List<Film> getTopRated(int number);
	public List<Film> getMostPopular(int number);
	public List<Film> getByGenre(Genre genre);
	public List<Film> getByName(String filmName);
	public void delete(Long id);
	public Film rateFilm(Long filmId, Integer rate, RegisteredUser user);
	public List<Film> saveFilmToFavourites(Long filmId, User user);
	public List<RecommendedFilm> getRecommendedFilms(RegisteredUser user, int number);
	public List<Film> save(List<Film> films);
}
