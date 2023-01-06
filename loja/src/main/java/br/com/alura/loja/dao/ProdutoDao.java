package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	
	public ProdutoDao(EntityManager em) {
		
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);  //método persist permite criar um objeto no banco de dados. E realizar as operações
	}
	
	public Produto buscarPorID(Long id) {
		
		return em.find(Produto.class, id);
	}
	
	public List<Produto> BuscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList(); 
		
	}
	
}
