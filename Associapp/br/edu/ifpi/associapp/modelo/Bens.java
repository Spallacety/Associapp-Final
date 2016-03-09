package br.edu.ifpi.associapp.modelo;

public class Bens {
	
	private String nome;
	private TipoEnum tipo;
	private int situacao;
	
	public enum TipoEnum {
		QUADRA, LAVANDERIA, PRACA, HOSPITAL,
		SISTEMADEABASTECIMENTODEAGUA, ILUMINACAOPUBLICA;
	}

	public Bens(String nome, TipoEnum tipo, int situacao) {
		this.nome = nome;
		this.tipo = tipo;
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return this.nome + " (" + this.tipo + ") " + "[Situacao: " + this.situacao + "]";
	}
}
