package ifpb.dac.banda;

import ifpb.dac.connection.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                                    rs.getString("localDeOrigem"), buscaIntegrantes(rs.getInt("id")));
            
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
                                    rs.getString("localDeOrigem"), buscaIntegrantes(rs.getInt("id")));
            
            con.close();
            return banda;
        }
        
        return null;
    }

    @Override
    public List<Banda> listarBandas() throws SQLException, ClassNotFoundException {
        con = ConnectionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM banda");
        ResultSet rs = stmt.executeQuery();

        List<Banda> bandas = new ArrayList<>();

        while (rs.next()) {
            Banda banda = new Banda(rs.getInt("id"), rs.getString("nome"), Estilo.valueOf(rs.getString("estilo")), 
                    rs.getString("localDeOrigem"), buscaIntegrantes(rs.getInt("id")));
            bandas.add(banda);
        }
        
        con.close();
        return bandas;
    }

    @Override
    public List<String> buscaIntegrantes(int banda) throws SQLException, ClassNotFoundException {
        con = ConnectionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT nome FROM artista WHERE banda = ?");
        stmt.setInt(1, banda);
        
        ResultSet rs = stmt.executeQuery();
        
        List<String> integrantes = new ArrayList<>();
        
        while(rs.next()){
            integrantes.add(rs.getString("nome"));
        }
        
        con.close();
        return integrantes;
    }
    
}
