package com.librarymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagementsystem.model.Library;
import com.librarymanagementsystem.services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryservice;
	
	@PostMapping
	public ResponseEntity<Library> saveBook(@RequestBody Library library) {
		try {
		 libraryservice.saveBook(library);
		 return new ResponseEntity<>(library,HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Library> getBookById(@PathVariable long id){
		Optional<Library> librarybook = libraryservice.getBookById(id);
		if(librarybook.isPresent()) {
			return new ResponseEntity<>(librarybook.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBook(){
		List<Library> all = libraryservice.getAllBook();
		if(all != null && !all.isEmpty()) {
			return new ResponseEntity<>(all,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public Library updateBook(@PathVariable long id, @RequestBody Library libray) {
		return libraryservice.updateBook(id, libray);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable long id) {
		libraryservice.deleteBookById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
