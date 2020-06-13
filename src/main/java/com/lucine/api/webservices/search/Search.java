package com.lucine.api.webservices.search;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="search")

public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date searchDate;

    public Search(){}

    public Search(Long id, Date searchDate){
        this.id = id;
        this.searchDate = searchDate;
    }

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
}
