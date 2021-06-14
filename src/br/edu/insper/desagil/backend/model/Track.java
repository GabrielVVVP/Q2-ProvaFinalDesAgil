package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private Integer duration;
	
	public Track(Artist artist, String name, Integer duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public Integer getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		Integer minutos = this.duration/60;
		Integer segundos = this.duration%60;
		String Resposta = "";
		if (segundos >=10) {
			Resposta = Integer.toString(minutos)+":"+Integer.toString(segundos);
		}
		else {
			Resposta = Integer.toString(minutos)+":0"+Integer.toString(segundos);
		}
		return Resposta;
	}
	
	public String getFullArtistName() {
		return artist.getName();
	}
}
