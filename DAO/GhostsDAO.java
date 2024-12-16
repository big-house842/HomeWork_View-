package DAO;

import java.sql.*;
import java.util.ArrayList;

import DataBase.*;
import Models.Ghost;

public class GhostsDAO {

    public static Ghost MostStrengthGhost() {
        String sql = "SELECT * FROM Ghost ORDER BY strength DESC";

        try (Connection conect = new Conexao().Conectar()) {

            PreparedStatement stmt = conect.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ghost phantom = new Ghost();
                phantom.ReadGhostWithID(rs.getInt("id"), rs.getString("nameGhost"), rs.getInt("strength"),
                        rs.getInt("size"));

                return phantom;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void InsertGhostBD(Ghost phantoms) {
        String sql = "Insert Into Ghost (nameGhost, strength, size) values(?,?,?)";

        try (Connection conect = new Conexao().Conectar()) {

            PreparedStatement stmt = conect.prepareStatement(sql);

            stmt.setString(1, phantoms.ReturnNameGhost());
            stmt.setInt(2, phantoms.ReturnStrength());
            stmt.setInt(3, phantoms.ReturnSize());

            stmt.executeUpdate();// Altera a tabela no DB

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int CountPhantomDB() {
        String sql = "SELECT COUNT(*) FROM Ghost";

        try (Connection conect = new Conexao().Conectar()) {

            PreparedStatement stmt = conect.prepareStatement(sql);

            // Aqui o correto é executeQuery, pois estamos realizando uma consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int qtd;
                qtd = rs.getInt("count(*)");

                return qtd;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public static void OrderDB(String column, ArrayList<Ghost> listPhantom) {
        String sql = "SELECT * FROM Ghost ORDER BY " + column.toLowerCase();// ? Não funciona para colunas parêmetros

        try (Connection conect = new Conexao().Conectar()) {

            PreparedStatement stmt = conect.prepareStatement(sql);

            // Aqui o correto é executeQuery, pois estamos realizando uma consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ghost phantom = new Ghost();
                phantom.ReadGhostWithID(rs.getInt("id"), rs.getString("nameGhost"), rs.getInt("strength"),
                        rs.getInt("size"));

                listPhantom.add(phantom);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Ghost> TakeOutGhostsBD(ArrayList<Ghost> listPhantom) {
        String sql = "SELECT * FROM Ghost";

        try (Connection connection = new Conexao().Conectar()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ghost phantom = new Ghost();
                phantom.ReadGhostWithID(rs.getInt("id"), rs.getString("nameGhost"), rs.getInt("strength"),
                        rs.getInt("size"));

                listPhantom.add(phantom);

            }
            return listPhantom;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Ghost SearchBD(String column, int value) {
        Ghost phantom = null;
        String sql = "SELECT * FROM Ghost WHERE " + column.toLowerCase() + " = ?"; // Construir a consulta SQL com a
                                                                                   // coluna diretamente

        try (Connection connection = new Conexao().Conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, value); // Substituir o "?" pelo valor de 'value'

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                phantom = new Ghost();
                phantom.ReadGhostWithID(rs.getInt("id"), rs.getString("nameGhost"), rs.getInt("strength"),
                        rs.getInt("size"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phantom;
    }

    public static void DeleteDB(String column, int value) {
        String sql = "DELETE FROM Ghost WHERE " + column.toLowerCase() + " = ?";

        try (Connection connection = new Conexao().Conectar()) {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, value);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}