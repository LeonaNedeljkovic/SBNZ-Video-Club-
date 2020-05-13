package com.videoClub.exception;

@SuppressWarnings("serial")
public class ArtistNotFound extends RuntimeException  {

private String message;
	
	public ArtistNotFound(Long id){
		super();
		this.message = "Artist with ID " + id +
				" does not exist in system.";
	}

	public String getMessage() {
		return message;
	}
}
