package ifpb.dac.banda;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public interface DaoBandaIF {
    
    public Banda buscarPorId(int id) throws SQLException, ClassNotFoundException;
    
    public Banda buscarPorNome(String nome) throws SQLException, ClassNotFoundException;
    
    public List<Banda> listarBandas() throws SQLException, ClassNotFoundException;
    
    public List<String> buscaIntegrantes(int banda) throws SQLException, ClassNotFoundException;
    
}
