package com.bytecode.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private final Log log = LogFactory.getLog(getClass());

	@Override
	public List<Post> validation(List<Post> posts) {
		log.info("Método de PostServiceImpl");
		for(Post post : posts) {
			if(post.getTitulo() == null) {
				throw new NullPointerException("El título tiene valor nulo");
			}
		}
		return posts;
	}

}
