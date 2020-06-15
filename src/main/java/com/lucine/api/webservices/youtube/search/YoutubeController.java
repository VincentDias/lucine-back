package com.lucine.api.webservices.youtube.search;


import com.lucine.api.webservices.youtube.search.models.YoutubeVideos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class YoutubeController {

    @Autowired
    YoutubeService service;


    @GetMapping("/ytbSearch")
    public YoutubeVideos getYoutubeVideos(@RequestParam String keywords) {

        return service.getYoutubeVideos(keywords);
    }
}
