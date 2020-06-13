package com.lucine.api.webservices.search;


import com.lucine.api.webservices.search.Search;
import com.lucine.api.webservices.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class SearchService {

    @Autowired
    SearchRepository repository;

    public List<Search> getAll(){
        return repository.findAll();
    }

    public Search getById(Long id){
        return repository.findById(id).get();
    }

    public void whenFindBySearchDate_thenVideoReturned(){
        List<Video> return repository.findAllBySearchDate(
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));
        assertEquals(2, result.size());
        assertTrue(result.stream()
                .map(Video::getId)
                .allMatch(id -> Array.asList(2, 3).parse("16:30"));

    }
}