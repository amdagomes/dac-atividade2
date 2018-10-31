package ifpb.dac.banda;

import ifpb.dac.connection.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class DaoBanda implements DaoBandaIF{
    
    private Connection con;
    
    @Override
    public Banda buscarPorId(int id) throws SQLException, ClassNotFoundException{
        con = ConnectionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM banda WHERE id = ?");
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Banda banda = new Banda(rs.getInt("id"), rs.getString("nome"), Estilo.valueOf(rs.getString("estilo")),
                                    rs.getString("localDeOrigem"));
            
            con.close();
            return banda;
        }
        con.close();
        return null;
    }

    @Override
    public Banda buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        con = ConnectionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM banda WHERE nome ilike ?");
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Banda banda = new Banda(rs.getInt("id"), rs.getString("nome"), Estilo.valueOf(rs.getString("estilo")),
                                    rs.getString("localDeOrigem"));
            
            con.close();
            return banda;
        }
        
        return null;
    }
    
}
