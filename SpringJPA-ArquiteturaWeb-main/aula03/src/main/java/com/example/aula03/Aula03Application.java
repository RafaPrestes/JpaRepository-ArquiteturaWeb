package com.example.aula03;

import java.util.List;

import com.example.aula03.entity.Categoria;
import com.example.aula03.entity.Produto;
import com.example.aula03.repository.CategoriaRepository;
import com.example.aula03.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula03Application {
	@Bean
	public CommandLineRunner init(@Autowired CategoriaRepository categoriaRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			Categoria comida = new Categoria(0, "Comida", "Frango, Boi, Porco, Frutos do Mar");
			Categoria roupa = new Categoria(0, "Roupas", "Camiseta, Shorts, Blusa");
			categoriaRepository.save(comida);
			categoriaRepository.save(roupa);

			Produto prod1 = new Produto(0, "Camisa Jordan", 5);
			prod1.setCategoria(roupa);
			produtoRepository.save(prod1);

			Produto prod2 = new Produto(0, "Parmegiana", 11);
			prod2.setCategoria(comida);
			produtoRepository.save(prod2);

			List<Produto> listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("*** PRODUTO ***");
			System.out.println("*** PESQUISAR PRODUTO POR PARAMETRO ***");
			System.out.println(produtoRepository.findByNomeLike("Ca%"));

			System.out.println("*** PESQUISAR PRODUTO POR QUANTIDADE < 10 *** ");
			System.out.println(produtoRepository.findByQtdLessThanEqual(10));

			System.out.println("*** PESQUISAR PRODUTO ORDENADO DE FORMA ASCENDENTE *** ");
			System.out.println(produtoRepository.findNomeByOrderByNomeAsc());

			System.out.println("*** TOP 10 PRODUTOS ***");
			System.out.println(produtoRepository.findTop10ByOrderByQtdDesc());

			System.out.println("*** CATEGORIA ***");
			System.out.println("*** CATEGORIA POR ID E LISTA DE PRODUTOS");
			System.out.println(categoriaRepository.findCategoriaByIdFetchProdutos(1));

			System.out.println("*** CATEGORIA POR NOME OBTENDO PARAMETROS");
			// System.out.println(categoriaRepository.findByNomeLike("Co%"));

			System.out.println("*** CATEGORIA QUE RETORNE A QUANTIDADE DE PRODUTOS POR ID ***");
			// System.out.println(categoriaRepository.findQtdByIdFetchProdutos(1));

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula03Application.class, args);
	}

}
