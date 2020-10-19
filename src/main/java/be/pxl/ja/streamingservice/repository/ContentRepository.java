package be.pxl.ja.streamingservice.repository;

import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Documentary;
import be.pxl.ja.streamingservice.model.Genre;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import be.pxl.ja.streamingservice.model.TVShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContentRepository {
	private List<Content> contentList = new ArrayList<>();

	public ContentRepository() {
		init();
	}

	public List<Content>  getContentList() {
		return contentList;
	}

	private void init() {
		Movie theIncredibles = new Movie("The Incredibles", Rating.LITTLE_KIDS);
		theIncredibles.setReleaseDate(LocalDate.of(2004, 10, 27));
		theIncredibles.setImageUrl("the_incredibles.jpeg");
		contentList.add(theIncredibles);

		Documentary planetEarth = new Documentary("Planet Earth", Rating.LITTLE_KIDS);
		planetEarth.setReleaseDate(LocalDate.of(2006, 3, 5));
		planetEarth.setImageUrl("planet_earth.jpeg");
		contentList.add(planetEarth);

		Movie jackRyan = new Movie("Jack Ryan: Shadow Recruit", Rating.TEENS);
		jackRyan.setReleaseDate(LocalDate.of(2004, 10, 27));
		jackRyan.setImageUrl("jack_ryan.jpeg");
		jackRyan.setGenre(Genre.ACTION);
		contentList.add(jackRyan);

		Movie mi = new Movie("Mission Impossible: Fall Out", Rating.TEENS);
		mi.setImageUrl("mi.jpeg");
		mi.setGenre(Genre.ACTION);
		contentList.add(mi);

		Movie ironFist = new Movie("Iron Fist", Rating.MATURE);
		ironFist.setReleaseDate(LocalDate.of(2004, 10, 27));
		ironFist.setImageUrl("iron_fist.jpeg");
		contentList.add(ironFist);

		Movie avengers = new Movie("Avengers: End Game", Rating.MATURE);
		avengers.setImageUrl("avengers_end_game.jpg");
		avengers.setGenre(Genre.SF);
		contentList.add(avengers);

		Movie pinocchio = new Movie("Pinocchio", Rating.OLDER_KIDS);
		pinocchio.setImageUrl("pinocchio.jpg");
		contentList.add(pinocchio);

		Movie spiderMan = new Movie("Spider man", Rating.OLDER_KIDS);
		spiderMan.setImageUrl("spider-man.jpg");
		contentList.add(spiderMan);

		Movie toyStory4 = new Movie("Toy story 4", Rating.LITTLE_KIDS);
		toyStory4.setImageUrl("toy_story_4.jpg");
		contentList.add(toyStory4);

		TVShow eigenKweek = new TVShow("Eigen kweek", Rating.TEENS, 3);
		eigenKweek.setImageUrl("eigen_kweek.jpeg");
		contentList.add(eigenKweek);

		TVShow emilyInParis = new TVShow("Emily in Paris", Rating.TEENS, 1);
		emilyInParis.setImageUrl("emily_in_paris.jpg");
		contentList.add(emilyInParis);

		TVShow lucifer = new TVShow("Lucifer", Rating.OLDER_KIDS, 5);
		lucifer.setImageUrl("lucifer.jpg");
		contentList.add(lucifer);

	}
}
