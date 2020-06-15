package com.lucine.api.webservices.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository repository;

    public List<Video> getAll() {
        return repository.findAll();
    }

    public Video getVideoById(Long id) { return repository.findById(id).get(); }

    public Video saveVideo(Video video) { return repository.save(video); }

    public Video updateVideo(Long id, Video video) {

        Video videoToUpdate = repository.findById(id).get();
        videoToUpdate.setTitle(video.getTitle());
        videoToUpdate.setIdYoutube(video.getIdYoutube());
        videoToUpdate.setViewCount(video.getViewCount());
        videoToUpdate.setLikeCount(video.getLikeCount());
        videoToUpdate.setPublishedAt(video.getPublishedAt());
        videoToUpdate.setChecked(video.getChecked());

        return repository.save(videoToUpdate);
    }

    public boolean deleteVideo(Long id) {
        repository.deleteById(id);
        return true;
    }
}
