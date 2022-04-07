package com.example.aula03.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.aula03.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    @Query("select p from Categoria p left join fetch p.produtos where p.id_categoria = :id_categoria")
    Categoria findCategorialByIdFetchProduto(@Param("id_categoria") int id_categoria);

    List<Categoria>findByNameLike(String cat_nome);

    @Query("(count) select p from Categoria p left join fetch p.prod_qtd where p.id_categoria = :id_categoria")
    Categoria findByQuantityById(@Param("id_categoria") int id_categoria);
   
}
