package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Artist artist;
	private Track track;
	private Track track2;
	private Playlist playlist;

	@BeforeEach
	void setUp() {
		artist = new Artist("Jessie J");
		track = new Track(artist,"Price Tag",220);
		track2 = new Track(artist,"Bang Bang",300);
		playlist = new Playlist(0);
		playlist.addTrack(track);
		playlist.addTrack(track2);
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("Gabriel", 1);
		playlist.putRating("Joao", 2);
		playlist.putRating("Pedro", 3);
		playlist.putRating("Paulo", 3);
		assertEquals(playlist.averageRatings(), 2.0,DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("Gabriel", 1);
		playlist.putRating("Joao", 2);
		playlist.putRating("Pedro", 1);
		assertEquals(playlist.averageRatings(), 1.5,DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("Gabriel", 1);
		playlist.putRating("Joao", 2);
		playlist.putRating("Pedro", 2);
		assertEquals(playlist.averageRatings(), 1.5,DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("Gabriel", 1);
		playlist.putRating("Joao", 1);
		playlist.putRating("Pedro", 2);
		playlist.putRating("Paulo", 3);
		assertEquals(playlist.averageRatings(), 2.0,DELTA);
	}
}
