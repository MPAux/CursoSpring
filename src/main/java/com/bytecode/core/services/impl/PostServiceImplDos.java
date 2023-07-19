package com.bytecode.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

	private final Log log = LogFactory.getLog(getClass());

	
	@Override
	public List<Post> validation(List<Post> posts) {
		log.info("Método de PostServiceImplDos");
		for(Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("La id es igual a 0");
			}
		}
		return posts;
	}

}
