package ifpb.dac.album;

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
public class DaoAlbum implements DaoAlbumIF {

    private Connection con;

    @Override
    public boolean adicionar(Album album) throws SQLException, ClassNotFoundException{
        con = ConnectionBD.getConnection();
        
        String sql = "INSERT INTO album(nome, banda, anoLancamento) VALUES(?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, album.getNome());
            stmt.setInt(2, album.getBanda());
            stmt.setInt(3, album.getAnoLancamento());
            stmt.execute();
            stmt.close();
        }

        con.close();
        return true;
    }

    @Override
    public boolean remover(int id) throws SQLException , ClassNotFoundException{
        con = ConnectionBD.getConnection();
        String sql = "DELETE FROM album WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        }

        con.close();
        return true;
    }

    @Override
    public boolean atualizar(Album album) throws SQLException, ClassNotFoundException {
        con = ConnectionBD.getConnection();
        String sql = "UPDATE album SET nome = ?, banda = ?, anoLancamento = ? WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, album.getNome());
            stmt.setInt(2, album.getBanda());
            stmt.setInt(3, album.getAnoLancamento());
            stmt.setInt(4, album.getId());
            stmt.execute();
            stmt.close();
        }
        
        con.close();
        return true;
    }

    @Override
    public List<Album> listaAlbum() throws SQLException, ClassNotFoundException {
        con = ConnectionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM album");
        ResultSet rs = stmt.executeQuery();

        List<Album> albuns = new ArrayList<>();

        while (rs.next()) {
            Album album = new Album(rs.getInt("id"), rs.getString("nome"), rs.getInt("banda"),
                    rs.getInt("anoLancamento"));
            albuns.add(album);
        }
        
        con.close();
        return albuns;
    }

}
