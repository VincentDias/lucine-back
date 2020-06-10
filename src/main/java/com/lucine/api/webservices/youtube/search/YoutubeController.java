package com.lucine.api.webservices.youtube.search;


import com.lucine.api.webservices.youtube.search.models.YoutubeVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class YoutubeController {

    @Autowired
    YoutubeService service;


    @GetMapping("/ytbSearch")
    public YoutubeVideo getYoutubeVideos(@RequestParam String keywords) {

        return service.getYoutubeVideos(keywords);
    }
}
