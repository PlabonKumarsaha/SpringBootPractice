package com.example.oneToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.example.oneToMany.entity.Comment;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    //cascade means if post is saved then comments will autosave
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "post_comment_fk",referencedColumnName = "id", nullable = false)
    List<Comment> comments = new ArrayList<>();

    public Post(){

    }

    public Post(String title, String description){
        super();
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
