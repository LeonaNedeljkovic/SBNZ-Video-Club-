package com.videoClub.service;

import java.util.List;

import com.videoClub.dto.VideoContentDTO;
import com.videoClub.model.VideoContent;

public interface VideoContentService {

	public VideoContent save(VideoContentDTO videoContentDTO);
	public VideoContent getOne(Long id);
	public List<VideoContent> getAll();
	//public List<VideoContent> getByActors();
	//public List<VideoContent> getByDirector(Long directorId);
	public void delete(Long id);
}