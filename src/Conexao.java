import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Conexao() {}
	
	public static Connection getConexao() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/veiculos", "postgres", "ciet");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

