package com.livros.Livros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.Livros.entities.Livro;
import com.livros.Livros.repositories.livRepository;
import com.livros.Livros.repositories.livRepository;


import jakarta.persistence.Entity;




@Service
public class livService {
	private final livRepository repository;
	
	@Autowired
	public livService(livRepository repository) {
		this.repository = repository;
}
	
	public Livro getEntityById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Livro> getAlllivro(){
		return repository.findAll();
	}
	
	public Livro savelivro(Livro livro) {
		return repository.save(livro);
	}
		
	public void deletelivro(Long id) {
		repository.deleteById(id);
	}
	public Livro updateLivro(Long id, Livro novoLivro) {
        Optional<Livro> livroOptional = repository.findById(id);
        if (livroOptional.isPresent()) {
        	Livro livroExistente = livroOptional.get();
           	livroExistente.setDescricao(novoLivro.getDescricao());
        	livroExistente.setIsbn(novoLivro.getIsbn());          
            return repository.save(livroExistente); 
        } else {
            return null; 
        }
	}
}
