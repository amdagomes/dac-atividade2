package ifpb.dac.command;

import ifpb.dac.album.DaoAlbum;
import ifpb.dac.banda.DaoBanda;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class Home implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        try {
            DaoAlbum daoAlbum = new DaoAlbum();
            DaoBanda daoBanda = new DaoBanda();
            
            session.setAttribute("albuns", daoAlbum.listaAlbum());
            session.setAttribute("bandas", daoBanda.listarBandas());
            
            response.sendRedirect("home.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
