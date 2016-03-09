package br.edu.ifpi.associapp.aplicacao;

import java.util.List;

import br.edu.ifpi.associapp.dao.ComunidadeDAO;
import br.edu.ifpi.associapp.dao.ComunidadeJDBCDAO;
import br.edu.ifpi.associapp.enums.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.*;

public class GerenciaComunidade {

	public static void main(String[] args) {
		
		Comunidade c = new Comunidade("WOW2", TipoDeComunidadeEnum.POVOADO, new Endereco("Rua Y", 2653, "64010-900"), 4, new Coordenadas(23, 34), 22);
		c.setHistorico("ISDUASDUO");
		ComunidadeDAO daoC = new ComunidadeJDBCDAO();
		Comunidade c1 = daoC.obter(1);
		
//		c.addBens(new Bens("Praca da Liberdade", Bens.PRACA, 5));
//		c.addAptidoesProdutivas(new AptidoesProdutivas("Bar do Seu Zé", AptidoesProdutivas.BAR));
		System.out.println(c1);
		daoC.inserir(c);
//		c.mostraListaDeBens();
//		c.mostraListaDeAptidoesProdutivas();
		
	}
}
