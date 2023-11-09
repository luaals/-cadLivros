package com.livros.Livros.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livros.Livros.entities.Livro;
import com.livros.Livros.service.livService;



@RestController
@RequestMapping("/livros")
public class livController {

	@GetMapping("/home")
	public String paginaInicial() {
		 return "index";
	}
	
private final livService livService;
	
	public livController (livService livService) {
		this.livService = livService;
}
	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
		Livro livro = livService.getEntityById(id);
		if (livro != null) {
		return ResponseEntity.ok(livro);
	} else {
		return ResponseEntity.notFound().build();
	}
	}
	@PostMapping
	public Livro createJogo(@RequestBody Livro livro) {
		return livService.savelivro(livro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livService.deletelivro(id);
	}
	
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<Livro>> getAllJogos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livro> livro = livService.getAlllivro();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}
		
		@PutMapping("/{id}")
		public Livro updateJogo(@PathVariable Long id, @RequestBody Livro livro) {
		    return livService.updateLivro(id, livro);
		}
}