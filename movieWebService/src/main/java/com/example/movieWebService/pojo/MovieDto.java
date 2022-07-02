package com.example.movieWebService.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private String Title;
	private String Year;
	private String imdbID;
	private String Type;
	private String Poster;

}
