package com.lucine.api.webservices.youtube.search;


import com.lucine.api.webservices.youtube.search.models.YoutubeVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YoutubeController {

    @Autowired
    YoutubeService service;

    @GetMapping("/ytbSearch")
    public YoutubeVideo getYoutubeVideos(@RequestBody List<String> keywords) {

        return service.getYoutubeVideos(keywords);
    }
}
