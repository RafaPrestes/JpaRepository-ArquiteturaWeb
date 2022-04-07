package com.example.aula03.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.aula03.entity.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto>findByNameLike(String prod_nome);
    List<Produto>findByQuantityLessThanEqual(Integer prod_qtd);
    List<Produto>findByNameOrderByNameAsc(String prod_nome);
    List<Produto>findTop10ByQtd(Integer prod_qtd);
}
