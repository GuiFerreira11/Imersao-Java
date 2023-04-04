package br.com.alura.linguagem.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
  List<Linguagem> findByOrderByRanking();

}