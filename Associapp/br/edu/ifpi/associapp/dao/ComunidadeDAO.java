package br.edu.ifpi.associapp.dao;

import java.util.List;

import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Familia;

public interface ComunidadeDAO {
	
	public Comunidade inserir(Comunidade c);
	public Familia inserirFamilia(Comunidade c, Familia f);
	public List<Comunidade> lista();
	public Comunidade obter(int id);
	public void remover(Comunidade c);

}
