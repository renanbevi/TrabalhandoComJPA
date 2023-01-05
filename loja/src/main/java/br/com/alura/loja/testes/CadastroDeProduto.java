package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("IPHONE");
		celular.setDescricao("11");
		celular.setPreco(new BigDecimal("800"));
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();//inicia a transação entitymanager
		dao.cadastrar(celular); //método persist permite criar um objeto no banco de dados. E realizar as operações
		em.getTransaction().commit(); //Commita a operação
		em.close(); // Fechar a conexão
		
	}

}
