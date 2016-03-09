package br.edu.ifpi.associapp.modelo;

import br.edu.ifpi.associapp.enuns.CargoEnum;

public class Gestor {
	
	private int id;
	private int id_gestao;
	private int id_pessoa;
	private CargoEnum cargo;
	private String formaDeDefiniçao;


//	public String toString() {
//		return "Gestor [Nome: " +  + ", Cargo: " + cargo + ", Forma De Definiçao: " + formaDeDefiniçao + "]\n";
//	}
	
	
	public int getId_gestao() {
		return id_gestao;
	}
	public void setId_gestao(int id_gestao) {
		this.id_gestao = id_gestao;
	}
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public CargoEnum getCargo() {
		return cargo;
	}
	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}
	
}
