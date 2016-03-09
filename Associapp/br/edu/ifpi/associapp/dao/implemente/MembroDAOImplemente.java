package br.edu.ifpi.associapp.dao.implemente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.dao.ConnectionFactory;
import br.edu.ifpi.associapp.dao.MembroDAO;
import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Membro;

public class MembroDAOImplemente implements MembroDAO {

	private Connection conn;
	
	@Override
	public Membro inserirMembro(Membro m) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO membro(nome, sexo, profissao, rendaMediaMensal) "
					+ "values('"+ m.getNome()+"', '"+ m.getSexo()+"', '" + m.getProfissao()+ "',"
					+ m.getRendaMediaMensal() + ");";
			
			System.out.println(sql);
			s.executeUpdate(sql);
			System.out.println("Membro inserido com sucesso!!");
			
			
//			ResultSet rs = s.executeQuery("SELECT * FROM membro;" );
//			while ( rs.next() ) {
//				int id = rs.getInt("id");
//				String nome = rs.getString("nome");
//				System.out.println(id);
//				System.out.println(nome);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Membro!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}

	@Override
	public Membro retornarMembroPorId(int id) {
		conn = ConnectionFactory.getConnection();
		Membro m = null;
		try {
			String sql = "SELECT * FROM membro WHERE id = " + id;
			
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				m = new Membro();
				m.setId(resultado.getInt("id"));
				m.setNome(resultado.getString("nome"));
				m.setProfissao(resultado.getString("profissao"));
				m.setRendaMediaMensal(resultado.getDouble("rendaMediaMensal"));
			}
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public void removerMembro(int id) {
		conn = ConnectionFactory.getConnection();
		try {
			Statement s = conn.createStatement();
			String sql = "DELETE from membro where id = " +id;
			
			s.executeUpdate(sql);
		
			System.out.println("Membro deletado com sucesso!!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao deletar Membro!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Membro> listaMembros() {
		conn = ConnectionFactory.getConnection();
		List<Membro> listaMembros = new ArrayList<>();
		String sql = "SELECT * FROM membro";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Membro m = new Membro();
				m = new Membro();
				m.setId(resultado.getInt("id"));
				m.setNome(resultado.getString("nome"));
				m.setProfissao(resultado.getString("profissao"));
				m.setRendaMediaMensal(resultado.getDouble("rendaMediaMensal"));
				listaMembros.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaMembros;
	}

	@Override
	public List<Membro> BuscarPorNome(String nome) {
		conn = ConnectionFactory.getConnection();
		List<Membro> listaMembros = new ArrayList<>();
		String sql = "SELECT * FROM membro where nome like '%"+ nome +"%'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Membro m = new Membro();
				m = new Membro();
				m.setId(resultado.getInt("id"));
				m.setNome(resultado.getString("nome"));
				m.setProfissao(resultado.getString("profissao"));
				m.setRendaMediaMensal(resultado.getDouble("rendaMediaMensal"));
				listaMembros.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaMembros;
	}

}
