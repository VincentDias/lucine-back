package com.lucine.api.webservices.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    @Autowired
    SearchService service;

    @GetMapping()
    public List<Search> index(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Search getById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteSearch(id);
    }

}
