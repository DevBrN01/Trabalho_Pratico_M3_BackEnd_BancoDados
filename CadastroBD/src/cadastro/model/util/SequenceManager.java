/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SequenceManager {
    
    public static int getValue(String sequenceName) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int nextValue = 0;

        try {
            
            conn = ConectorBD.getConnection();

            String sql = "SELECT NEXT VALUE FOR " + sequenceName;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

          
            if (rs.next()) {
                nextValue = rs.getInt(1);
            }
        } finally {
           
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return nextValue;
    }
}