package ifpb.dac.banda;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class BuscarBanda extends SimpleTagSupport{
    
    private int id;
    
    @Override
    public void doTag(){
        DaoBanda dao;
        try {
            dao = new DaoBanda();
            getJspContext().setAttribute("banda", dao.buscarPorId(id));
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
