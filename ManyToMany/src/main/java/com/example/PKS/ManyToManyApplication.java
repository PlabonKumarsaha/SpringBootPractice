package com.example.PKS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.PKS.Repository.PostRepository;
import com.example.PKS.Repository.TagRepository;
import com.example.PKS.entity.Post;
import com.example.PKS.entity.Tag;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner{
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	TagRepository tagRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Post post = new Post("HiberNet many to many example with spring",
				"This is the description","This is spring boot content");
		
		Post post1 = new Post("another HiberNet many to many example with spring",
				"Another This is the description","Another This is spring boot content");
		Tag tag = new Tag("Spring boot");
		Tag tag1 = new Tag("Spring Hibernet");
		
		//add tag posts
		post.getTags().add(tag);
		post.getTags().add(tag1);
		
		//add post refernce tag
		
		tag.getPosts().add(post);
		tag1.getPosts().add(post);
		
		tag.getPosts().add(post1);
		tag1.getPosts().add(post1);
		
		postRepository.save(post);
		postRepository.save(post1);
		
		
		
	}

}
