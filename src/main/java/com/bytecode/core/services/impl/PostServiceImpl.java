package com.bytecode.core.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public List<Post> validateId(List<Post> posts) {
		System.out.println("Método de PostServiceImpl");
		for(Post post : posts) {
			if(post.getTitulo() == null) {
				throw new NullPointerException("El título tiene valor nulo");
			}
		}
		return posts;
	}

}
