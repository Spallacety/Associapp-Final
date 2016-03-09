package br.edu.ifpi.associapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.enums.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Familia;

public class ComunidadeJDBCDAO implements ComunidadeDAO {

	private Connection conn;

	@Override
	public Comunidade inserir(Comunidade c) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			if (c.getEndereco().isHouse()){
				if (c.getEndereco().getComplemento() == null){
					String sql = "INSERT INTO endereco(rua, numero, cep) VALUES('"+ c.getEndereco().getRua()+"',"
							+ " " + c.getEndereco().getNumero() + ", '" + c.getEndereco().getCep() +"')";
					s.executeUpdate(sql);
				} else {
					String sql = "INSERT INTO endereco(rua, numero, cep, complemento) VALUES('"+ c.getEndereco().getRua()+"',"
							+ " " + c.getEndereco().getNumero() + ", '" + c.getEndereco().getCep() +"',"
							+ " '" + c.getEndereco().getComplemento() + "')";
					s.executeUpdate(sql);
				}
			} else {
				String sql = "INSERT INTO endereco(rua, numero, cep, complemento) VALUES('"+ c.getEndereco().getRua()+"',"
						+ " " + c.getEndereco().getNumero() + ", '" + c.getEndereco().getCep() +"',"
						+ " '" + c.getEndereco().getComplemento() + "')";
				s.executeUpdate(sql);	
			}
			
			String sql = "SELECT id FROM endereco ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int idEndereco = rs.getInt("id");
			c.setIdEndereco(idEndereco);
			
			sql = "INSERT INTO comunidade(nome, idadeMinimaLider, tipo, idEndereco, indiceDeSeguranca, coordenadas, historico) values('"+c.getNome()+"', "
					+c.getIdadeMinimaLider()+", '"+c.getTipo()+"', '"+c.getIdEndereco()+"', '"+ c.getIndiceDeSeguranca()+"', '" + c.getCoordenadas()+ "', '" + c.getHistorico() + "')";
			s.executeUpdate(sql);
			
			sql = "SELECT id FROM comunidade ORDER BY id DESC limit 1";
			rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			c.setId(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Comunidade");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public Familia inserirFamilia(Comunidade c, Familia f) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO familia(endereco, id_comunidade) values('"+f.getEndereco()+"', "
					+c.getId()+")";
			s.executeUpdate(sql);
			sql = "SELECT id FROM familia ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			f.setCodigo(id);
			c.addFamilias(f);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Familia");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return f;
	}

	@Override
	public List<Comunidade> lista() {
		List<Comunidade> lista = new ArrayList<>();
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM comunidade";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Comunidade c = new Comunidade();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setIdadeMinimaLider(resultado.getInt("idadeMinimaLider"));
				c.setTipo(TipoDeComunidadeEnum.valueOf(resultado.getString("tipo")));
				lista.add(c);
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
		
		return lista;
	}
	
	@Override
	public Comunidade obter(int id) {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM comunidade WHERE id = " + id;
		Comunidade c = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()){
				c = new Comunidade();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setIdadeMinimaLider(resultado.getInt("idadeMinimaLider"));
				c.setTipo(TipoDeComunidadeEnum.valueOf(resultado.getString("tipo")));
				c.setIdEndereco(resultado.getInt("idEndereco"));
				c.setIndiceDeSeguranca(resultado.getInt("indiceDeSeguranca"));
				c.setHistorico(resultado.getString("historico"));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Familia obterFamilia(int id) {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM familia WHERE id = " + id;
		Familia f = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				f = new Familia();
				f.setCodigo(resultado.getInt("id"));
			}
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remover(Comunidade c) {
		// TODO Auto-generated method stub
		
	}

}
