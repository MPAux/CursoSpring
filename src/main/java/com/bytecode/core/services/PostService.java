package com.bytecode.core.services;

import java.util.List;

import com.bytecode.core.model.Post;

public interface PostService {
	
	public List<Post> validateId(List<Post> posts);
	
}
