package com.example.PKS.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;;


@Entity
@Table(name = "Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "descripton")
	private String descripton;
	@Column(name = "contenet")
	private String content;
	@Column(name = "postedAt")
	private Date postedDate = new Date();
	@Column(name = "lastUpdated")
	private Date lastupdatedAt = new Date();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "post_tags",
	        joinColumns = {@JoinColumn(name="post_id")} ,
	        inverseJoinColumns = {@JoinColumn(name="tag_id")}
			)
	private Set<Tag>tags = new HashSet<>();
	
	public Post() {
		
	}
	
	
	public Post(String title, String descripton, String content) {
		super();
		this.title = title;
		this.descripton = descripton;
		this.content = content;
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
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public Date getLastupdatedAt() {
		return lastupdatedAt;
	}
	public void setLastupdatedAt(Date lastupdatedAt) {
		this.lastupdatedAt = lastupdatedAt;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	

}
