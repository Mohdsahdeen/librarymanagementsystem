package com.librarymanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.model.Library;
import com.librarymanagementsystem.repository.LibraryRepository;

@Service
public class LibraryService implements LibraryServiceInterface {
	
	@Autowired
    private	LibraryRepository libraryrepository;

	@Override
	public Library saveBook(Library library) {
		
		return libraryrepository.save(library) ;
	}

	@Override
	public Optional<Library> getBookById(long id) {
		
		return libraryrepository.findById(id);
	}

	@Override
	public List<Library> getAllBook() {
	
		return libraryrepository.findAll();
	}

	@Override
	public Library updateBook(long id, Library library) {
		Library updatebook = libraryrepository.findById(id).orElseThrow();
		
		updatebook.setName(library.getName());
		updatebook.setAuthor(library.getAuthor());
		updatebook.setDescription(library.getDescription());
		
		
		
		return libraryrepository.save(updatebook);
	}

	@Override
	public void deleteBookById(long id) {
		
		libraryrepository.deleteById(id);
		
	}
	
	
	
	

}
