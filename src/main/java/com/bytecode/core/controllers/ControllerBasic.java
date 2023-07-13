package com.bytecode.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.core.configuration.Paginas;
import com.bytecode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<Post>();

		posts.add(new Post(1,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post"));
		posts.add(new Post(2,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 2"));
		posts.add(new Post(3,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 3"));
		posts.add(new Post(4,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 4"));
		
		return posts;
	}
	/*
	@GetMapping(path= {"/post","/"})
	public String saludar(Model model) {
		model.addAttribute("posts", getPosts());
		return "index";
	}
	*/
	
	@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts", getPosts());
		return modelAndView;
	}
	
	@GetMapping(path = {"/post", "/post/{post}"})
	public ModelAndView getPostIndividual(
			//@RequestParam(defaultValue="1", name="id", required=false) 
			@PathVariable(required=true, name="post") int id	
			) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> postFiltrado = this.getPosts().stream().filter(
				(p) -> {
					return p.getId() == id;
				}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		System.out.println("ENTRANDO EN EL FORM");
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this.getPosts();
		posts.add(post);
		model.addAttribute("posts", posts);
		return "index";
	}
	
}
