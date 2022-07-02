package com.example.movieWebService.service.abstracts;

import java.util.List;

import com.example.movieWebService.pojo.MovieDto;



public interface MovieService {
	
	List<MovieDto> movieFindByName(String name);

	
        
     

}
