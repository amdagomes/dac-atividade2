package ifpb.dac.command;

import ifpb.dac.album.Album;
import ifpb.dac.album.DaoAlbum;
import ifpb.dac.banda.Banda;
import ifpb.dac.banda.DaoBanda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class CadastroAlbum implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String nome = request.getParameter("nome");
        String nomeBanda = request.getParameter("banda");
        int ano = Integer.parseInt(request.getParameter("ano"));
        
        try {
            DaoAlbum daoAlbum = new DaoAlbum();
            DaoBanda daoBanda = new DaoBanda();
            
            Banda banda = daoBanda.buscarPorNome(nomeBanda);
            
            if(banda == null){
                response.sendRedirect("index.jsp?erro=1");
            } else{
                Album album = new Album();
                album.setNome(nome);
                album.setBanda(banda.getId());
                album.setAnoDeLancamento(ano);
                
                if(daoAlbum.adicionar(album)){
                    response.sendRedirect("index.jsp?sucesso=1");
                } else{
                    response.sendRedirect("index.jsp?erro=2");
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
