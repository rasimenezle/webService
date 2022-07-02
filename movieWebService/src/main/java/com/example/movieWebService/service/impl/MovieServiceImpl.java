package com.example.movieWebService.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.movieWebService.pojo.MovieDto;
import com.example.movieWebService.pojo.MovieDtoResultSearch;
import com.example.movieWebService.service.abstracts.MovieService;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MovieServiceImpl implements MovieService {

	private RestTemplate template = new RestTemplate();

	@Autowired
	public MovieServiceImpl(RestTemplateBuilder builder) {
		template = builder.build();
	}

	@Override
	public List<MovieDto> movieFindByName(String name) {

		String uri = "https://api.collectapi.com/imdb/imdbSearchByName?query=";

		ResponseEntity<String> response = getResponseEntity(uri, HttpMethod.GET, name);
	

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		List<MovieDto> movieDtos = new ArrayList<>();
		MovieDtoResultSearch movieDtoResultSearch = new MovieDtoResultSearch();
		try {

			movieDtoResultSearch = objectMapper.readValue(response.getBody().getBytes(), MovieDtoResultSearch.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movieDtoResultSearch.getResult();
	}

	private ResponseEntity<String> getResponseEntity(String url, HttpMethod httpMethod, String parameter) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/json");
		headers.add("authorization", "apikey 6e9cJyxW9it2ZTKayQmMyb:3ogpv0dxPN8BffOHja8OHl");

		HttpEntity<?> responseEntity = new HttpEntity<>(headers);
		String uri = url + parameter;

		return template.exchange(uri, HttpMethod.GET, responseEntity, String.class);

	}
}
