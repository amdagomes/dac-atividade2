package ifpb.dac.command;

import ifpb.dac.album.Album;
import ifpb.dac.album.DaoAlbum;
import ifpb.dac.banda.Banda;
import ifpb.dac.banda.DaoBanda;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class AtualizarAlbum implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String bandaNome = request.getParameter("banda");
        int ano = Integer.parseInt(request.getParameter("ano"));
        
        try {
            DaoAlbum dao = new DaoAlbum();
            DaoBanda daoBanda = new DaoBanda();
            Banda banda = daoBanda.buscarPorNome(bandaNome);
            dao.atualizar(new Album(id, nome, banda.getId(), ano));
            
            session.setAttribute("albuns", dao.listaAlbum());
            response.sendRedirect("home.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
