package com.lucine.api.webservices.search;

import com.lucine.api.webservices.video.Video;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="search")

public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date searchDate;

    @OneToMany
    @JoinColumn(name ="search_id")
    private List<Video> videos;

    public Search(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateSearch() {
        return searchDate;
    }

    public void setDateSearch(Date searchDate) {
        this.searchDate = searchDate;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
