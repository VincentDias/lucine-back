package com.lucine.api.webservices.youtube.search;


import com.lucine.api.webservices.youtube.search.models.YoutubeVideo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class YoutubeService {

    public YoutubeVideo getYoutubeVideos(List<String> keywords) {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://www.googleapis.com/youtube/v3")
                        .build();

        return webClient.get()

                .uri(UriBuilder -> UriBuilder
                        .path("/search")
                        .queryParam("part", "snippet")
                        .queryParam("maxResults", 1)
                        .queryParam("q", keywords)
                        .queryParam("key", "AIzaSyBiT2_dE36crA2m4jeXNX20fDSDS7uXq1A")
                        .build())
                .retrieve()
                .bodyToMono(YoutubeVideo.class).block();
    }
}