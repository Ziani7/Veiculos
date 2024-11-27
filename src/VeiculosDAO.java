import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class VeiculosDAO {
	
	private Connection conexao;
	
	public VeiculosDAO() {
		this.conexao = Conexao.getConexao();
	}
	
	public boolean InserirVeiculo(Veiculos v) {
		String sql = "INSERT INTO veiculos (marca,modelo,ano) VALUES (?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ps.setString(1, v.getMarca());
			ps.setString(2, v.getModelo());
			ps.setInt(3, v.getAno());
			boolean retorno =  ps.execute();
			ps.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public LinkedList<String> listarVeiculosCombo(String filtro) {
		String sql = "select " + filtro + " from veiculos";
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			LinkedList<String> itens = new LinkedList<String>();
			while(rs.next()) {
				itens.add(rs.getString(filtro));
			}
			rs.close();
			ps.close();
			return itens;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LinkedList<Veiculos> listarVeiculos(String filtro1, String filtro2){
		String sql = "select * from veiculos where " + filtro1 + " = " + filtro2;
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			LinkedList<Veiculos> itens = new LinkedList<Veiculos>();
			while(rs.next()) {
				Veiculos v = new Veiculos(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
				v.setId(rs.getInt("id"));
				itens.add(v);
			}
			rs.close();
			ps.close();
			return itens;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
