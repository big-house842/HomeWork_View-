package DataBase;

import java.sql.*;

public class Conexao {

    public Connection Conectar() {

        String url = "jdbc:mysql://localhost:3306/BancoDeDados";
        String usuario = "aluno";
        String senha = "aluno";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            return conexao;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
            
        }

    }

}