package br.edu.ifpi.associapp.modelo;

public class AptidoesProdutivas {

	private String nome;
	private TipoEnum tipo;
	
	public enum TipoEnum {
		BAR, HORTA, COMERCIO;
	}
	
	
	public AptidoesProdutivas(String nome, TipoEnum tipo){
		this.nome = nome;
		this.tipo = tipo;
	}
	
	@Override
	public String toString(){
		return this.nome + " (" + this.tipo + ")";
	}
}
