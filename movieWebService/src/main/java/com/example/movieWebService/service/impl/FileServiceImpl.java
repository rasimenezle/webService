package com.example.movieWebService.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movieWebService.pojo.MovieDetailDto;
import com.example.movieWebService.pojo.MovieDetailResult;
import com.example.movieWebService.service.abstracts.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileServiceImpl implements FileService {

	private RestTemplate template = new RestTemplate();

	@Autowired
	public FileServiceImpl(RestTemplateBuilder builder) {
		template = builder.build();
	}

	@Override
	public MovieDetailDto movieFindDetailById(String id) {

		String uri = "https://api.collectapi.com/imdb/imdbSearchById?movieId=";
		ResponseEntity<String> response = getResponseEntity(uri, HttpMethod.GET, id);

		MovieDetailDto movieDetailObject = new MovieDetailDto();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		MovieDetailResult movieDetailResult = new MovieDetailResult();

		File output = new File("src/main/resources/output.txt");

		try {
			movieDetailResult = objectMapper.readValue(response.getBody().getBytes(), MovieDetailResult.class);

			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			bw.write(movieDetailResult.getResult().toString());
			bw.newLine();
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return movieDetailObject;

	}

	@Override
	public MovieDetailDto movieFindDetailByIdToFile(String id) {
		MovieDetailDto movieDetail = new MovieDetailDto();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		try {
			File jsonInputFile = new File("src/main/resources/output.txt");

			BufferedReader buf = new BufferedReader(new FileReader(jsonInputFile));

			while (buf.ready()) {
				String data = buf.readLine();
				if (data.contains(id)) {
					movieDetail = mapper.readValue(jsonInputFile, MovieDetailDto.class);

				}

			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return movieDetail;
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
