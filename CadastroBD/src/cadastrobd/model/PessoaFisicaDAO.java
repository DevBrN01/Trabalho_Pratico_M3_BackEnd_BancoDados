/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;
import cadastro.model.util.ConectorBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PessoaFisicaDAO {
    
    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT * FROM Pessoa WHERE cpf IS NOT NULL";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();
                pf.setId(rs.getInt("id"));
                pf.setNome(rs.getString("nome"));
                pf.setLogradouro(rs.getString("logradouro"));
                pf.setCidade(rs.getString("cidade"));
                pf.setEstado(rs.getString("estado"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setEmail(rs.getString("email"));
                pf.setCpf(rs.getString("cpf"));

                lista.add(pf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return lista;
    }
    
    public PessoaFisica getPessoa(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PessoaFisica pf = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT * FROM Pessoa WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setId(rs.getInt("id"));
                pf.setNome(rs.getString("nome"));
                pf.setLogradouro(rs.getString("logradouro"));
                pf.setCidade(rs.getString("cidade"));
                pf.setEstado(rs.getString("estado"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setEmail(rs.getString("email"));
                pf.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return pf;
    }

   
    public void incluir(PessoaFisica pf) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, pf.getNome());
            stmt.setString(2, pf.getLogradouro());
            stmt.setString(3, pf.getCidade());
            stmt.setString(4, pf.getEstado());
            stmt.setString(5, pf.getTelefone());
            stmt.setString(6, pf.getEmail());
            stmt.setString(7, pf.getCpf());

            stmt.executeUpdate();
            System.out.println("✅ Pessoa Física inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }
    }
 
    public void alterar(PessoaFisica pf) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cpf = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pf.getNome());
            stmt.setString(2, pf.getLogradouro());
            stmt.setString(3, pf.getCidade());
            stmt.setString(4, pf.getEstado());
            stmt.setString(5, pf.getTelefone());
            stmt.setString(6, pf.getEmail());
            stmt.setString(7, pf.getCpf());
            stmt.setInt(8, pf.getId());
            stmt.executeUpdate();
            System.out.println("✅ Pessoa Física atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }
    }

    public void excluir(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "DELETE FROM Pessoa WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Pessoa Física excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }
    }
}