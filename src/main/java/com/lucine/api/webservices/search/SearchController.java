package com.lucine.api.webservices.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Search")

public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @GetMapping()
    public List<Search> index(){
        return searchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Search getOne(@PathVariable Long id){
        return searchRepository.findById(id).get();
    }

    /*
    @PostMapping("/searchDate")
    public List<Search> getDate(@RequestBody Map<Date, Date> body){
    Date dateresearch = body.get("");
        return searchRepository.
    }

    @DeleteMapping("{/id}")
    public void delete(@PathVariable Long id){
        searchRepository.deleteById(id);
        return;
    }

     */

}
