package com.example.movieWebService.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDetailDto implements Serializable {
	
	private String title;
	private String year;
	private String imdbID;
	private String type;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdbRating;
	private String imdbVotes;
	private String dVD;
	private String boxOffice;
	private String production;
	private String website;
	private String response;
	private List<MovieRating> ratings;
	@Override
    public String toString() {
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		sb.append("\"imdbID\": ").append("\"").append(imdbID).append("\"").append(",");
		sb.append("\"Title\": ").append("\"").append(title).append("\"").append(",");
		sb.append("\"Year\": ").append("\"").append(year).append("\"").append(",");
		sb.append("\"Type\": ").append("\"").append(type).append("\"").append(",");
		sb.append("\"Rated\": ").append("\"").append(rated).append("\"").append(",");
		sb.append("\"Released\": ").append("\"").append(released).append("\"").append(",");
		sb.append("\"Runtime\": ").append("\"").append(runtime).append("\"").append(",");
		sb.append("\"Genre\": ").append("\"").append(genre).append("\"").append(",");
		sb.append("\"Director\": ").append("\"").append(director).append("\"").append(",");
		sb.append("\"Writer\": ").append("\"").append(writer).append("\"").append(",");
		sb.append("\"Actors\": ").append("\"").append(actors).append("\"").append(",");
		sb.append("\"Plot\": ").append("\"").append(plot).append("\"").append(",");
		sb.append("\"Language\": ").append("\"").append(language).append("\"").append(",");
		sb.append("\"Country\": ").append("\"").append(country).append("\"").append(",");
		sb.append("\"Awards\": ").append("\"").append(awards).append("\"").append(",");
		sb.append("\"Poster\": ").append("\"").append(poster).append("\"").append(",");
		
		sb.append("\"Metascore\": ").append("\"").append(metascore).append("\"").append(",");
		sb.append("\"imdbRating\": ").append("\"").append(imdbRating).append("\"").append(",");
		sb.append("\"imdbVotes\": ").append("\"").append(imdbVotes).append("\"").append(",");
		sb.append("\"DVD\": ").append("\"").append(dVD).append("\"").append(",");
		sb.append("\"BoxOffice\": ").append("\"").append(boxOffice).append("\"").append(",");
		sb.append("\"Production\": ").append("\"").append(production).append("\"").append(",");
		sb.append("\"Website\": ").append("\"").append(website).append("\"").append(",");
		sb.append("\"Response\": ").append("\"").append(response).append("\"").append(",");
		sb.append("\"Ratings\": ").append(ratings).append(",");
		sb.append("\"Website\": ").append("\"").append(website).append("\"");
		sb.append("}");
		return sb.toString();
		
		
       

    }



	
	
	
	

}
