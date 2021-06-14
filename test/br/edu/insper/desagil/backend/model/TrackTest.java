package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	
	private Artist artist;
	private Track track;
	private CollaborationTrack collab;
	
	@BeforeEach
	void setUp() {
		artist = new Artist("Jessie J");
	}

	@Test
	void testZeroSeconds() {
		track = new Track(artist,"Price Tag",0);
		assertEquals(track.getDurationString(), "0:00");
	}

	@Test
	void testFiveSeconds() {
		track = new Track(artist,"Price Tag",5);
		assertEquals(track.getDurationString(), "0:05");
	}

	@Test
	void testTwentyFiveSeconds() {
		track = new Track(artist,"Price Tag",25);
		assertEquals(track.getDurationString(), "0:25");
	}

	@Test
	void testOneMinuteZeroSeconds() {
		track = new Track(artist,"Price Tag",60);
		assertEquals(track.getDurationString(), "1:00");
	}

	@Test
	void testOneMinuteFiveSeconds() {
		track = new Track(artist,"Price Tag",65);
		assertEquals(track.getDurationString(), "1:05");
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		track = new Track(artist,"Price Tag",85);
		assertEquals(track.getDurationString(), "1:25");
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		track = new Track(artist,"Price Tag",120);
		assertEquals(track.getDurationString(), "2:00");
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		track = new Track(artist,"Price Tag",125);
		assertEquals(track.getDurationString(), "2:05");
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		track = new Track(artist,"Price Tag",145);
		assertEquals(track.getDurationString(), "2:25");
	}

	@Test
	void testOneCollaborator() {
		collab = new CollaborationTrack(artist, Arrays.asList(new Artist("Becky G")), "Price Tag", 195);
		assertEquals(collab.getFullArtistName(), "Jessie J (feat. Becky G)");
	}

	@Test
	void testTwoCollaborators() {
		collab = new CollaborationTrack(artist, Arrays.asList(new Artist("Becky G"),new Artist("Lady Gaga")), "Price Tag", 195);
		assertEquals(collab.getFullArtistName(), "Jessie J (feat. Becky G, Lady Gaga)");
	}
}
