package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private Integer id;
	private List<Track> tracks;
	private Map<String,Integer> ratings;
	
	public Playlist(Integer id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	
	public Integer getId() {
		return id;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String nome, Integer avaliacao) {
		this.ratings.put(nome, avaliacao);
	}
	
	public double averageRatings() {
		double average = 0;
		for (Integer avaliacao : this.ratings.values()) {
			average += avaliacao;
		}
		average = average/this.ratings.size();
		int i = (int) average;
		double d = average - i;
		if (d < 0.26) {
			d = 0.0;
		}
		else if ((d>=0.26)&&(d<0.74)) {
			d = 0.5;
		}
		else {
			d = 1.0;
		}
		average = i + d;
		return average;
	}

}
