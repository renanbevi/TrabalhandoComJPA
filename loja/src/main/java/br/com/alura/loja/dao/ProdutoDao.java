package br.com.alura.loja.dao;

import java.math.BigDecimal;
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
	
	public List<Produto> BuscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
		return em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)
				.getResultList(); 
		
	}
	
	public List<Produto> BuscarPorCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1"; //não precisa realizar o JOIN manual
		return em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)
				.getResultList(); 
	}
	
	public BigDecimal BuscarPrecoDoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = ?1"; //não precisa realizar o JOIN manual
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter(1, nome)
				.getSingleResult(); //método que carrega um unico resultado
	}
	
	public List<Produto> BuscarDescricaoDoProdutoComNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1"; //não precisa realizar o JOIN manual
		return em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)
				.getResultList();  //método que carrega um unico resultado
	}
	
	
	}
