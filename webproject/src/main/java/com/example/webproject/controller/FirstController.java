package com.example.webproject.controller;


import com.example.webproject.dto.*;
import com.example.webproject.entity.Article;
import com.example.webproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j// 로깅을 위한 골뱅이(어노테이션)
public class FirstController {

	@Autowired//스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
	private ArticleRepository articleRepository;

	@GetMapping("/hi")
	public String niceToMeetYou(Model model){
		model.addAttribute("username", "Yohan");

		return "greetings";
	}

	@GetMapping("by")
	public String bye(Model model){
		model.addAttribute("nickname","굿바이 페이지입니다.");
		return "bye";
	}


	@GetMapping("new")
	public String form(){


		return"artices/new";
	}

	@PostMapping("create")
	public String create(dto doDto) {

		log.info(doDto.toString());
		//System.out.println(doDto.toString()); -> 로깅기능으로 대체!


		//1. Dto -> entity 변환
		Article article = doDto.toEntity();
		log.info(article.toString());


		//2. Repoitory
		Article saved = articleRepository.save(article);
		log.info(saved.toString());

		return "";
	}

}
