package br.edu.insper.desagil.backend.model;

import java.util.List;

public class CollaborationTrack extends Track {
	private List<Artist> collaborators;
	
	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, Integer duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		String Resposta = this.getArtist().getName();
		if (this.collaborators.size() > 0) {
			Resposta = Resposta+" (feat. ";
			for (Artist collaborator : this.collaborators) {
				Resposta = Resposta+collaborator.getName()+", ";
			}
			Resposta = Resposta.substring(0,Resposta.lastIndexOf(","));
			Resposta = Resposta+")";
		}
		return Resposta;
		
	};

}
