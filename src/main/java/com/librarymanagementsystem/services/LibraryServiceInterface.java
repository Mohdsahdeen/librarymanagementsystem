package com.librarymanagementsystem.services;

import java.util.List;
import java.util.Optional;

import com.librarymanagementsystem.model.Library;

public interface LibraryServiceInterface {
	
	public Library saveBook(Library library);
	
	public Optional<Library> getBookById(long id);
	
	List<Library> getAllBook();
	
	Library updateBook(long id, Library library);
	
	public void deleteBookById(long id);
	
	
	
	

}
