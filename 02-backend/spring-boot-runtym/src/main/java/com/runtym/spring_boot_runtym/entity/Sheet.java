package com.runtym.spring_boot_runtym.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sheet")
@Data
public class Sheet {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JsonProperty("title")
	@Column(name = "title")
	private String title;
	
	@JsonProperty("description")
	@Column(name = "description")
	private String description;
	
	@JsonProperty("category")
	@Column(name = "category")
	private String category;
	
	@JsonProperty("img")
	@Column(name = "img")
	private String img;
	
	@JsonProperty("download_link")
	@Column(name = "download_link")
	private String download_link;
}
