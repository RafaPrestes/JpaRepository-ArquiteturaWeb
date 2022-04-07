package com.example.aula03.repository;

import java.util.List;

import com.example.aula03.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    List<Usuario> findByNomeLike(String nome);
}
