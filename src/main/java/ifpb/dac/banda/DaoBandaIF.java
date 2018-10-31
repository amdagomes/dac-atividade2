package ifpb.dac.banda;

import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public interface DaoBandaIF {
    
    public Banda buscarPorId(int id) throws SQLException, ClassNotFoundException;
    
    public Banda buscarPorNome(String nome) throws SQLException, ClassNotFoundException;
    
}
