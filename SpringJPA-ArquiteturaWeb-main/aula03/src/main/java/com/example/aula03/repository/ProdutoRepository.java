package com.example.aula03.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.aula03.entity.Categoria;
import com.example.aula03.entity.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeLike(String nome);

    List<Produto> findByQtdLessThanEqual(Integer qtd);

    List<Produto> findNomeByOrderByNomeAsc();

    List<Produto> findTop10ByOrderByQtdDesc();
}
