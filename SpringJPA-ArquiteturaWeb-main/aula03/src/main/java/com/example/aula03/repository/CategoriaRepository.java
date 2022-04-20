package com.example.aula03.repository;

import java.util.List;

import com.example.aula03.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("select p from Categoria p left join fetch p.produtos where p.id = :id")
    Categoria findCategoriaByIdFetchProdutos(@Param("id") int id);

    List<Categoria> findByNomeLike(String nome);

    /*
     * @Query("select p from Categoria p left join fetch p.qtd where p.id = :id")
     * Categoria findQtdByIdFetchProdutos(@Param("id") int id);
     */

}
