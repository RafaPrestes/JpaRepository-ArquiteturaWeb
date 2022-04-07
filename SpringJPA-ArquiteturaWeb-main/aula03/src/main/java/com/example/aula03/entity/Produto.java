package com.example.aula03.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int id_produto;
    @Column(length = 100)
    private String prod_nome;
    private int prod_qtd;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Produto(int id_produto, String prod_nome, int prod_qtd) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
    }

    public Produto() {

    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public int getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }

    @Override
    public String toString() {
        return "Id: " + id_produto + ", Nome do Produto: " + prod_nome + ", Quantidade: " + prod_qtd + ", Categoria: " +
                (categoria != null ? categoria.getCat_nome() : "");
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
