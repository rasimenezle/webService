package com.example.movieWebService.service.abstracts;

import com.example.movieWebService.pojo.MovieDetailDto;


public interface FileService {
	MovieDetailDto movieFindDetailById(String id);
	MovieDetailDto movieFindDetailByIdToFile(String id);

}
