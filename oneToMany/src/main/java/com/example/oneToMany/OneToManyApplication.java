package com.example.oneToMany;

import com.example.oneToMany.entity.Comment;
import com.example.oneToMany.entity.Post;
import com.example.oneToMany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);



	}
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		Post post = new Post("This is new post","new post...details are unknowsn");
		Comment comment1 = new Comment("c1");
		Comment comment2 = new Comment("c2");
		Comment comment3 = new Comment("c3");
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		postRepository.save(post);
		Post post2 = new Post("This is new post2","Two new post...details are unknowsn");
		post2.getComments().add(comment3);
		postRepository.save(post2);


	}
}
