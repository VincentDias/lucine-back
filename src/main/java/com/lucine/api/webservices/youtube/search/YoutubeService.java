package com.lucine.api.webservices.youtube.search;


import com.lucine.api.webservices.youtube.search.models.YoutubeVideos;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class YoutubeService {

    public YoutubeVideos getYoutubeVideos(String keywords) {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://www.googleapis.com/youtube/v3")
                        .build();

        return webClient.get()

                .uri(UriBuilder -> UriBuilder
                        .path("/search")
                        .queryParam("part", "snippet")
                        .queryParam("maxResults", 5)
                        .queryParam("q", keywords)
                        .queryParam("key", System.getenv("youtube_api_key"))
                        .build())
                .retrieve()
                .bodyToMono(YoutubeVideos.class).block();
    }
}