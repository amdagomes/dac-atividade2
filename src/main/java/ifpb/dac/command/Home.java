package ifpb.dac.command;

import ifpb.dac.album.DaoAlbum;
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
            session.setAttribute("albuns", daoAlbum.listaAlbum());
            
            response.sendRedirect("home.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
