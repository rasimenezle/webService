package com.example.movieWebService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieWebService.pojo.MovieDetailDto;

import com.example.movieWebService.pojo.MovieDto;
import com.example.movieWebService.service.abstracts.FileService;
import com.example.movieWebService.service.abstracts.MovieService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path="/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private FileService fileService;


	@GetMapping(path = "/search") 
	public List<MovieDto> getMovieSearchByName(@RequestParam (name="query") String title)
    {
        return this.movieService.movieFindByName(title);
    }
	
	@GetMapping(path="/getDetail/{id}") 
	public boolean getAllDetailId(@PathVariable (name="id") String id) {
		MovieDetailDto movieDetail=fileService.movieFindDetailById(id);

		
		return true;
	}
	
	@GetMapping(path="/getDetailFile/{id}")
    public MovieDetailDto getFile(@PathVariable(name="id") String id){
          MovieDetailDto movieDto=fileService.movieFindDetailByIdToFile(id);
        
         
          if(id.equals(movieDto.getImdbID())) {
        	
              return movieDto;
          }else {
        	 
              return fileService.movieFindDetailById(id);
          }


    }
	

}
