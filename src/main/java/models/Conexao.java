package models;

import java.sql.*;

public class Conexao {
	
    private static final String URL = "jdbc:mysql://localhost:3306/bd_usuarios";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";
	public static Connection java;

    private Connection conexao;

    public Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                System.out.println("Driver    JDBC não encontrado: " + e.getMessage());
            }
        }
        return conexao;
	
}

	public static Connection java() {
		return null;
	}
}