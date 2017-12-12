package com.charlie.example.model.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="articles")
public class Article implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
    private int articleId;
	@NotBlank
	@NotNull
	@Column(name="title")
	private String title;
	@NotBlank
	@NotNull
	@Column(name="category")	
	private String category;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="entry_date")	
	private Date entryDate = new Date();
	
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="complete_entry_date", length = 23, nullable = false)	
	private Date completeEntryDate = new Date();
	
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getCompleteEntryDate() {
		return completeEntryDate;
	}
	public void setCompleteEntryDate(Date completeEntryDate) {
		this.completeEntryDate = completeEntryDate;
	}
	private transient Boolean completed = false;
	
	
	
	
	
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
} 