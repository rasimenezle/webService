package com.example.movieWebService.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class MovieRating implements Serializable {
	
	private String Source;
	private String Value;
	
	
	 @Override
	    public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append("{");
		 sb.append("\"Source\":").append("\"").append(Source).append("\"").append(",");
			sb.append("\"Value\": ").append("\"").append(Value).append("\"").append("}");
		 
	        return sb.toString();
	
	
	
}
	} 
