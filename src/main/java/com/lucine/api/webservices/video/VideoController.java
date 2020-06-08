package com.lucine.api.webservices.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoRepository repository;

    @GetMapping("/videos")
    public List<Video> getVideos() {
        return repository.findAll();
    }

    @GetMapping("/videos/{id}")
        public Video getVideoById(@PathVariable int id) {
            return repository.findById(id).get();
        }

    @PostMapping("/videos")
    public Video create(@RequestBody Video video) {
        return repository.save(video);
    }

    @PutMapping("/videos/{id}")
    public Video update(@PathVariable int id, @RequestBody Video video) {

        Video videoToUpdate = repository.findById(id).get();
        videoToUpdate.setTitle(video.getTitle());
        videoToUpdate.setIdYoutube(video.getIdYoutube());
        videoToUpdate.setViewCount(video.getViewCount());
        videoToUpdate.setLikeCount(video.getLikeCount());
        videoToUpdate.setPublishedAt(video.getPublishedAt());
        videoToUpdate.setChecked(video.getChecked());

        return repository.save(videoToUpdate);
    }

    @DeleteMapping("/videos/{id}")
    public boolean delete(@PathVariable int id) {
        repository.deleteById(id);
        return true;
    }

}
