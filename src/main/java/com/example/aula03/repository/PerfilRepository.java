package com.example.aula03.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.aula03.entity.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
   
    @Query("select p from Perfil p left join fetch p.usuarios where p.id = :id")
    Perfil findPerfilByIdFetchUsuarios(@Param("id") int id);
}
