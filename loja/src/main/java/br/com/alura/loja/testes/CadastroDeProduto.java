package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorID(1l); // Consulta o banco de dados e busca o produto pelo ID
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.BuscarTodos(); //buscando por todos
		todos.forEach(p2 -> System.out.println(p.getNome() + " " + p.getDescricao() + " " + p.getDataCadastro()+ " " + p.getPreco()));
		
		List<Produto> nome = produtoDao.BuscarPorNome("IPHONE"); //buscando por nome especifico
		nome.forEach(p2 -> System.out.println(p.getNome() + " " + p.getDescricao() + " " + p.getDataCadastro()+ " " + p.getPreco()));
		
		List<Produto> nomeCategoria = produtoDao.BuscarPorCategoria("CELULARES"); //buscando por nome da categoria 
		nomeCategoria.forEach(p2 -> System.out.println(p.getNome() + " " + p.getDescricao() + " " + p.getDataCadastro()+ " " + p.getPreco()));
	
		BigDecimal precoDoProduto = produtoDao.BuscarPrecoDoProdutoComNome("IPHONE"); //buscando por nome e trazendo somente o preço
		System.out.println(precoDoProduto);
	
		List<Produto> nomeDescricao = produtoDao.BuscarDescricaoDoProdutoComNome("IPHONE"); //buscando por nome da categoria 
		nomeDescricao.forEach(p2 -> System.out.println(p.getDescricao()));
	
	}
	
			

	private static void cadastrarProduto() {
		Produto celular = new Produto();
		celular.setNome("IPHONE");
		celular.setDescricao("11");
		celular.setPreco(new BigDecimal("800"));
		Categoria celulares = new Categoria("CELULARES");
		
			
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();//inicia a transação entitymanager
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular); //método persist permite criar um objeto no banco de dados. E realizar as operações
		em.getTransaction().commit(); //Commita a operação
		em.close(); // Fechar a conexão
	}

}
