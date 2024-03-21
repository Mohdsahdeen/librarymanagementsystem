package com.librarymanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LibraryDBS")
@Getter
@Setter
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
	
	private String name;
	
	private String author;
	
    private	String description;
	

}
