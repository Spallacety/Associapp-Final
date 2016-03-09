package br.edu.ifpi.associapp.menus;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.edu.ifpi.associapp.aplicacao.App;
import br.edu.ifpi.associapp.dao.MembroDAO;
import br.edu.ifpi.associapp.dao.implemente.MembroDAOImplemente;
import br.edu.ifpi.associapp.modelo.Membro;

public class MenuMembro {
	private static MembroDAO membroDAO = new MembroDAOImplemente();
	
	public static void menuMembro() {
		String submenu ="1 - Adicionar Pessoa\n"
				+ "2 - Consultar Pessoa\n"
				+ "3 - Listar todas as Pessoas\n"
				+ "4 - Remover Pessoa\n"
				+ "0 - Retornar ao menu principal\n";
		
		while(true){
			
			int op = Integer.parseInt(JOptionPane.showInputDialog(submenu));
			switch (op){
			case 1:
				novoMembro();
				break;
			case 2:
				String n = JOptionPane.showInputDialog("Digite o nome procurado: ");
				buscarMembro(n);
				break;	
			case 3:
				lista();
				break;
			case 4:
				removerMembro();
				break;	
			case 0:
				App.menuPrincipal();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
			if (op == 0)
				break;
			
			
		}
				
	}
	
	public static void novoMembro() {
		UIManager.put("OptionPane.okButtonText", "Proximo");
		String nome = JOptionPane.showInputDialog("Nome: ");
		UIManager.put("OptionPane.okButtonText", "Proximo");
		char sexo = JOptionPane.showInputDialog("Sexo: (M ou F) ").toUpperCase().charAt(0);
		UIManager.put("OptionPane.okButtonText", "Proximo");
		String Profissao = JOptionPane.showInputDialog("Profissao: ");
		UIManager.put("OptionPane.okButtonText", "Fim");
		double renda = Double.parseDouble(JOptionPane.showInputDialog("Renda: "));
		Membro m = new Membro(nome,sexo,Profissao,renda);
	
		m = membroDAO.inserirMembro(m);

		JOptionPane.showMessageDialog(null, "Inseriu com sucesso. Id gerado: "+m.getId()+"!");
	}
	
	public static void lista() {
		String membros = "";
		for (Membro m : membroDAO.listaMembros()) {
			membros += m.toString().replace("null", "");
		}
		
		JOptionPane.showMessageDialog(null, membros);
	}
	
	public static void removerMembro() {
		String texto = "";
		for (Membro m : membroDAO.listaMembros()) {
			texto += m.getId()+ "\n" +  m.toString().replace("null", "");
		}
		int id = Integer.valueOf(JOptionPane.showInputDialog(texto +"\n\nDigite o numero correspondente a pessoa"));
		
		membroDAO.removerMembro(id);
	}
	
	public static void buscarMembro(String nome) {
		List<Membro>listaBusca ;
		listaBusca = membroDAO.BuscarPorNome(nome);
		String texto = "";
		for (Membro list : listaBusca) {
			texto += list.getId()+ "\n" +  list.toString().replace("null", "");
		}
				
		JOptionPane.showMessageDialog(null, texto);
	}
	
	

}
