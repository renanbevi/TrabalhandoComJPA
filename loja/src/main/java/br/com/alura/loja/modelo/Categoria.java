package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Anotação para avisar que a classe é uma entidade
@Table(name = "categorias") // JPA informando que o nome da nossa tabela é produtos
public class Categoria {
	
	@Id // informa qual é o dado primary key da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa como o valor é gerado
	private Long id;
	private String nome;
	
		
	public Categoria(String nome) {
		this.nome = nome;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
