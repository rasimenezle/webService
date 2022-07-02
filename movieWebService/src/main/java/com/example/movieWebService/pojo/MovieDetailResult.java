package com.example.movieWebService.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDetailResult {
	private boolean success;
	private MovieDetailDto result;

}
