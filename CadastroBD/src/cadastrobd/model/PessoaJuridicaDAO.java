/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastro.model.util.ConectorBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    
    public List<PessoaJuridica> getPessoas() {
        List<PessoaJuridica> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT * FROM Pessoa WHERE cnpj IS NOT NULL";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pj = new PessoaJuridica();
                pj.setId(rs.getInt("id"));
                pj.setNome(rs.getString("nome"));
                pj.setLogradouro(rs.getString("logradouro"));
                pj.setCidade(rs.getString("cidade"));
                pj.setEstado(rs.getString("estado"));
                pj.setTelefone(rs.getString("telefone"));
                pj.setEmail(rs.getString("email"));
                pj.setCnpj(rs.getString("cnpj"));

                lista.add(pj);
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

    
    public PessoaJuridica getPessoa(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PessoaJuridica pj = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT * FROM Pessoa WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pj = new PessoaJuridica();
                pj.setId(rs.getInt("id"));
                pj.setNome(rs.getString("nome"));
                pj.setLogradouro(rs.getString("logradouro"));
                pj.setCidade(rs.getString("cidade"));
                pj.setEstado(rs.getString("estado"));
                pj.setTelefone(rs.getString("telefone"));
                pj.setEmail(rs.getString("email"));
                pj.setCnpj(rs.getString("cnpj"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return pj;
    }

   
    public void incluir(PessoaJuridica pj) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, pj.getNome());
            stmt.setString(2, pj.getLogradouro());
            stmt.setString(3, pj.getCidade());
            stmt.setString(4, pj.getEstado());
            stmt.setString(5, pj.getTelefone());
            stmt.setString(6, pj.getEmail());
            stmt.setString(7, pj.getCnpj());

            stmt.executeUpdate();
            System.out.println("✅ Pessoa Jurídica inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }
    }

   
    public void alterar(PessoaJuridica pj) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cnpj = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, pj.getNome());
            stmt.setString(2, pj.getLogradouro());
            stmt.setString(3, pj.getCidade());
            stmt.setString(4, pj.getEstado());
            stmt.setString(5, pj.getTelefone());
            stmt.setString(6, pj.getEmail());
            stmt.setString(7, pj.getCnpj());
            stmt.setInt(8, pj.getId());

            stmt.executeUpdate();
            System.out.println("✅ Pessoa Jurídica atualizada com sucesso!");
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
            System.out.println("✅ Pessoa Jurídica excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }
    }
}