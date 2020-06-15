package com.lucine.api.webservices.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    VideoService service;

    @GetMapping()
    public List<Video> getVideos() {
        return service.getAll();
    }

    @GetMapping("/{id}")
        public Video getVideoById(@PathVariable int id) {
            return service.getVideoById(id);
        }

    @PostMapping()
    public Video create(@RequestBody Video video) {
        return service.saveVideo(video);
    }

    @PutMapping("/{id}")
    public Video update(@PathVariable int id, @RequestBody Video video) {

        return service.updateVideo(id, video);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
       return service.deleteVideo(id);
    }

}
