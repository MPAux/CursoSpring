package com.bytecode.core.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bytecode.core.model.Post;

@Component("com.bytecode.core.components.PostComponent")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {
	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<Post>();

		posts.add(new Post(1,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post"));
		posts.add(new Post(2,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 2"));
		posts.add(new Post(3,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 3"));
		posts.add(new Post(4,"The best post about the beast. Read this!!", "/img/eddieMask.jpg",new Date(), "Eddie's post 4"));
		
		return posts;
	}
}
