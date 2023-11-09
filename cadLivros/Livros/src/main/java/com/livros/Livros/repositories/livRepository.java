package com.livros.Livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.Livros.entities.Livro;


public interface livRepository extends JpaRepository<Livro, Long> {

}
