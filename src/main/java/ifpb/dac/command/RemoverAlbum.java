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
public class RemoverAlbum implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            DaoAlbum dao = new DaoAlbum();
            dao.remover(id);
            
            session.setAttribute("albuns", dao.listaAlbum());
            response.sendRedirect("home.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
