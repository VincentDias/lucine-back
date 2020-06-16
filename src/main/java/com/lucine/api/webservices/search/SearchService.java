package com.lucine.api.webservices.search;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteSearch(Long id){
        repository.deleteById(id);
    }
}