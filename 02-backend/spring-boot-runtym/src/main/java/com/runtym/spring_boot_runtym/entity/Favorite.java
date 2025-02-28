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
@Table(name = "favorite")
@Data
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JsonProperty("user_email")
	@Column(name = "user_email")
	private String userEmailString;
	
	@JsonProperty("sheet_id")
	@Column(name = "sheet_id")
	private Long sheetId;
	
	@JsonProperty("review_description")
	@Column(name = "review_description")
	private String reviewDescription;
}
