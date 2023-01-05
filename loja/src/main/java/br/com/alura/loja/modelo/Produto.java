package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Anotação para avisar que a classe é uma entidade
@Table(name = "produtos") // JPA informando que o nome da nossa tabela é produtos
public class Produto {

	@Id // informa qual é o dado primary key da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa como o valor é gerado
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
