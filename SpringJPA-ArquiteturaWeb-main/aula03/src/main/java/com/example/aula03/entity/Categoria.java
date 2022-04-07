package com.example.aula03.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    private String cat_nome;
    private String cat_descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria(int id_categoria, String cat_nome, String cat_descricao) {
        this.id_categoria = id_categoria;
        this.cat_nome = cat_nome;
        this.cat_descricao = cat_descricao;
    }

    public Categoria() {

    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    public String getCat_descricao() {
        return cat_descricao;
    }

    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Categoria [cat_descricao=" + cat_descricao + ", cat_nome=" + cat_nome + ", id_categoria=" + id_categoria
                + ", produtos=" + produtos + "]";
    }

}
