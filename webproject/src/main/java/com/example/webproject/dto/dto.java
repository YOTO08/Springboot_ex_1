package com.example.webproject.dto;

import com.example.webproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@AllArgsConstructor
@ToString
public class dto {

	private  String title;
	private  String content;



	public Article toEntity() {
		return new Article(null, title,content);
	}
}
