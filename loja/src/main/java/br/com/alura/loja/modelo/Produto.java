package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private LocalDate dataCadastro = LocalDate.now(); // cadastrando a data local
	
	//Obrigado a informar o relacionamento 1-1 ou 1-n ou n-1
	@ManyToOne //muitos produtos vinculados com 1 categoria
	private Categoria categoria;
	

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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria celulares) {
		this.categoria = celulares;
	}
	
	

}
