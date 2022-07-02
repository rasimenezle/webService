package com.example.movieWebService.pojo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class MovieDtoResultSearch {
	private boolean success;
	private List<MovieDto> result;

}
