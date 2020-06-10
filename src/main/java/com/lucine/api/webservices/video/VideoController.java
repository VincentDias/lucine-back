package com.lucine.api.webservices.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService service;

    @GetMapping("/videos")
    public List<Video> getVideos() {
        return service.getAll();
    }

    @GetMapping("/videos/{id}")
        public Video getVideoById(@PathVariable int id) {
            return service.getVideoById(id);
        }

    @PostMapping("/videos")
    public Video create(@RequestBody Video video) {
        return service.saveVideo(video);
    }

    @PutMapping("/videos/{id}")
    public Video update(@PathVariable int id, @RequestBody Video video) {

        return service.updateVideo(id, video);
    }

    @DeleteMapping("/videos/{id}")
    public boolean delete(@PathVariable int id) {
       return service.deleteVideo(id);
    }

}
