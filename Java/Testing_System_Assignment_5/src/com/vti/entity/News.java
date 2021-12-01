package com.vti.entity;

import java.util.Arrays;

public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float[] Rates;
	float averageRate;

	public News(String title, String publishDate, String author, String content, float[] Rates) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.Rates = Rates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float[] getRates() {
		return Rates;
	}

	@Override
	public void display() {
		System.out.println("News [title=" + title + ", publishDate=" + publishDate + ", author=" + author + ", content="
				+ content + ", Rates=" + Arrays.toString(Rates) + "]");
	}

	@Override
	public float calculate() {
		// TODO Auto-generated method stub
		averageRate = (Rates[0] + Rates[1] + Rates[2]) / 3;
		System.out.println("News [title=" + title + ", publishDate=" + publishDate + ", author=" + author + ", content="
				+ content + ", Rates=" + Arrays.toString(Rates) + ", averageRate=" + averageRate + "]");
		return 0;
	}

}
