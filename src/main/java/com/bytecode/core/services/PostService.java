package com.bytecode.core.services;

import java.util.List;

import com.bytecode.core.model.Post;

public interface PostService {
	
	public List<Post> validation(List<Post> posts) throws NullPointerException;
	
}
