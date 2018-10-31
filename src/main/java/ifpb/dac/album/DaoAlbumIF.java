package ifpb.dac.album;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public interface DaoAlbumIF {
    
    public boolean adicionar(Album album) throws SQLException, ClassNotFoundException;
    
    public boolean remover(int id) throws SQLException, ClassNotFoundException;
    
    public boolean atualizar(Album album) throws SQLException, ClassNotFoundException;
    
    public List<Album> listaAlbum() throws SQLException, ClassNotFoundException; 

}
