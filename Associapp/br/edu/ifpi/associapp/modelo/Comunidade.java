package br.edu.ifpi.associapp.modelo;

import java.util.*;

import br.edu.ifpi.associapp.enums.TipoDeComunidadeEnum;

public class Comunidade {

	private int id;
	private String nome;
	private int idadeMinimaLider;
	private TipoDeComunidadeEnum tipo;
	private int idEndereco;
	private Endereco endereco;
	private int indiceDeSeguranca;
	private Coordenadas coordenadas;
	private String historico;
	private List<Familia> familias = new ArrayList<>();
	private List<AptidoesProdutivas> aptidoesProdutivas = new ArrayList<>();
	private List<Bens> bens = new ArrayList<>();
	
	public Comunidade() {
	}
	
	public Comunidade(String nome, TipoDeComunidadeEnum tipo, Endereco endereco, int indiceDeSeguranca,
			Coordenadas coordenadas, int idadeMinimaLider) {
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
		this.indiceDeSeguranca = indiceDeSeguranca;
		this.coordenadas = coordenadas;
		this.idadeMinimaLider = idadeMinimaLider;
	}
		
	public void addFamilias(Familia familia){
		this.familias.add(familia);
	}
	
	public void addBens(Bens bem){
		this.bens.add(bem);
	}
	
	public void addAptidoesProdutivas(AptidoesProdutivas aptidoesProdutivas){
		this.aptidoesProdutivas.add(aptidoesProdutivas);
	}
	
	public void mostraListaDeBens(){
		for (Bens bem : bens) {
			System.out.println(bem);
		}
	}

	public void mostraListaDeAptidoesProdutivas(){
		for (AptidoesProdutivas aptidoesProdutivas : aptidoesProdutivas) {
			System.out.println(aptidoesProdutivas);
		}
	}

		public void setCoordenadas(Coordenadas coordenadas){
		this.coordenadas = coordenadas;
	}
	
	@Override
	public String toString() {
		String str = this.id + " - Nome da comunidade: " + this.nome + " (" + this.tipo + ")\n";
		return str;
	}

	public int getIdadeMinimaLider() {
		return this.idadeMinimaLider;
	}

	public TipoDeComunidadeEnum getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setIdadeMinimaLider(int idade) {
		this.idadeMinimaLider = idade;
		
	}

	public void setTipo(TipoDeComunidadeEnum tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getIndiceDeSeguranca() {
		return indiceDeSeguranca;
	}

	public void setIndiceDeSeguranca(int indiceDeSeguranca) {
		this.indiceDeSeguranca = indiceDeSeguranca;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public List<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Familia> familias) {
		this.familias = familias;
	}

	public List<AptidoesProdutivas> getAptidoesProdutivas() {
		return aptidoesProdutivas;
	}

	public void setAptidoesProdutivas(List<AptidoesProdutivas> aptidoesProdutivas) {
		this.aptidoesProdutivas = aptidoesProdutivas;
	}

	public List<Bens> getBens() {
		return bens;
	}

//	public void setBens(List<Bens> bens) {
//		this.bens = bens;
//	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}