package br.edu.ifpi.associapp.aplicacao;

import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Data;
import br.edu.ifpi.associapp.modelo.Membro;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.dao.ComunidadeDAO;
import br.edu.ifpi.associapp.dao.ComunidadeJDBCDAO;
import br.edu.ifpi.associapp.dao.MembroDAO;
import br.edu.ifpi.associapp.dao.implemente.MembroDAOImplemente;
import br.edu.ifpi.associapp.enuns.*;

public class Teste {

	public static void main(String[] args) {
			
//			ComunidadeDAO dao = new ComunidadeJDBCDAO();
//			
//			Comunidade c = new Comunidade();
//			c.setNome("SANTA MARIA");
//			c.setTipo(TipoDeComunidadeEnum.POVOADO);
//			c.setIdadeMinimaLider(18);;
//			
//			c = dao.inserir(c);
//			
//			c = dao.obter(2);
//			System.out.println("Inseriu com sucesso. Id gerado:"+c.getNome());
		
			MembroDAO membroDAO = new MembroDAOImplemente();
			
			Membro m = new Membro();
			m.setNome("Joana");
			m.setSexo('M');
			m.setProfissao("Dona do lar");
			m.setRendaMediaMensal(300);
			
			m = membroDAO.inserirMembro(m);
//			
//			m = membroDAO.retornarMembroPorId(2);
//			System.out.println(m.getNome());
//			System.out.println(m.getProfissao());
//			System.out.println(m.getRendaMediaMensal());
//			
//			membroDAO.removerMembro(2);
			
//			List<Membro> listMembros = new ArrayList<>();
//			
//			listMembros = membroDAO.listaMembros();
//			
//			for (Membro m : listMembros) {
//				System.out.println(m.getId());
//				System.out.println(m.getNome());
//				System.out.println(m.getProfissao());
//				System.out.println(m.getRendaMediaMensal());
//			}
//			
		}
	

}
