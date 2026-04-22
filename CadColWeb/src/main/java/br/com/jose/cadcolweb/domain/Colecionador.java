package br.com.jose.cadcolweb.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Colecionador {

	@Id
	private String cpf;
	private String nome;
	private String telefone;
	private int idade;

	public Colecionador() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, idade, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colecionador other = (Colecionador) obj;
		return Objects.equals(cpf, other.cpf) && idade == other.idade && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
