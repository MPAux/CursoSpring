package com.bytecode.core.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

	@Override
	public List<Post> validateId(List<Post> posts) {
		System.out.println("Método de PostServiceImplDos");
		for(Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("La id es igual a 0");
			}
		}
		return posts;
	}

}
