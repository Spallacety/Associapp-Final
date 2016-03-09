package br.edu.ifpi.associapp.modelo;

public class Endereco {
	
	private String rua;
	private int numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String regiao;
	private ZonaEnum zona;
	private boolean isHouse = false;
	
	public enum ZonaEnum{
		RURAL, URBANA;
	}
	

	public Endereco(String cidade, String regiao, ZonaEnum zona) {
		this.cidade = cidade;
		this.regiao = regiao;
		this.zona = zona;
	}
	
	public Endereco(String rua, int numero, String cep){
		this.isHouse = true;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	public Endereco(String rua, int numero, String complemento, String cep) {
		this.isHouse = true;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
	
	public String toString() {
		if (isHouse){
			if (this.complemento == null){
				return this.rua + ", N.º " + this.numero + ", CEP " + this.cep; 
			} else{
				return this.rua + ", N.º " + this.numero + ", CEP " + this.cep + " (" + this.complemento + ")"; 
			}
		} else {
			return this.cidade + ", Regiao " + this.regiao + ", Zona " + this.zona;
		}
	}
	
	
}
