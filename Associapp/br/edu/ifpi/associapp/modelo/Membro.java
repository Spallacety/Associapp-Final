package br.edu.ifpi.associapp.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.enuns.GrauDeInstucaoEnum;
import br.edu.ifpi.associapp.enuns.ReligiaoEnum;
import br.edu.ifpi.associapp.enuns.SituacaoLaboralEnum;
import br.edu.ifpi.associapp.enuns.TimeDeFutebolEnum;

public class Membro {

	private int id;
	private int id_familia;
	private String nome;
	private Data dataDeNascimento;
	private char sexo;
	private String profissao;
	private SituacaoLaboralEnum situacaoLaboral;
	private double rendaMediaMensal;
	private ReligiaoEnum religiao;
	private TimeDeFutebolEnum timeDeFutebol;
	private GrauDeInstucaoEnum grauDeInstrucao;
	private List<Contato> contatos = new ArrayList<>();
	private List<Parentesco> parentescos;
	
	public Membro() {
		// TODO Auto-generated constructor stub
	}
	
	public Membro(String nome, char sexo, String profissao, double renda) {
		this.nome = nome;
		this.sexo = sexo;
		this.profissao = profissao;
		this.rendaMediaMensal = renda;
	}
	
	public Membro(String nome, Data dataDeNascimento, char sexo, String profissao, SituacaoLaboralEnum situacaoLaboral, double rendaMediaMensal,
			ReligiaoEnum religiao, TimeDeFutebolEnum timeDeFutebol, GrauDeInstucaoEnum grauDeInstrucao) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
		this.profissao = profissao;
		this.situacaoLaboral = situacaoLaboral;
		this.rendaMediaMensal = rendaMediaMensal;
		this.setReligiao(religiao);
		this.timeDeFutebol = timeDeFutebol;
		this.grauDeInstrucao = grauDeInstrucao;
	}
	
	public void addContato(Contato contato){
		this.contatos.add(contato);
	}
	
	public void mostraContatos(){
		for (Contato contato : contatos) {
			System.out.println(contato);
		}
	}
	
	public void addParentesco(Membro p, TipoParentesco tp){
		Parentesco parentesco1 = new Parentesco();
		parentesco1.setParente(p);
		parentesco1.setTipo(tp);
		this.parentescos.add(parentesco1);
		Parentesco parentesco2 = new Parentesco();
		parentesco2.setParente(this);
		parentesco2.setTipo(tp.getEspelho());
		p.getParentescos().add(parentesco2);
	}
	
	public List<Parentesco> getParentescos() {
		return parentescos;
	}


	public ReligiaoEnum getReligiao() {
		return religiao;
	}

	public void setReligiao(ReligiaoEnum religiao) {
		this.religiao = religiao;
	}

	@Override
	public String toString() {
		String str = "Nome: " + this.nome + "\nData de nascimento: " + this.dataDeNascimento + "\nSexo: " +this.sexo + "\n\n";
		return str;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_familia() {
		return id_familia;
	}

	public void setId_familia(int id_familia) {
		this.id_familia = id_familia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Data dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public SituacaoLaboralEnum getSituacaoLaboral() {
		return situacaoLaboral;
	}

	public void setSituacaoLaboral(SituacaoLaboralEnum situacaoLaboral) {
		this.situacaoLaboral = situacaoLaboral;
	}

	public double getRendaMediaMensal() {
		return rendaMediaMensal;
	}

	public void setRendaMediaMensal(double rendaMediaMensal) {
		this.rendaMediaMensal = rendaMediaMensal;
	}

	public TimeDeFutebolEnum getTimeDeFutebol() {
		return timeDeFutebol;
	}

	public void setTimeDeFutebol(TimeDeFutebolEnum timeDeFutebol) {
		this.timeDeFutebol = timeDeFutebol;
	}

	public GrauDeInstucaoEnum getGrauDeInstrucao() {
		return grauDeInstrucao;
	}

	public void setGrauDeInstrucao(GrauDeInstucaoEnum grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void setParentescos(List<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}
	
	
	
}
