package ifpb.dac.banda;

import java.util.List;

/**
 *
 * @author Amanda
 */
public class Banda {
     
    private int id;
    private String nome;
    private Estilo estilo;
    private String localDeOrigem;
    private List<String> integrates;

    public Banda() {
    }

    public Banda(int id, String nome, Estilo estilo, String localDeOrigem, List<String> integrates) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.localDeOrigem = localDeOrigem;
        this.integrates = integrates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public List<String> getIntegrates() {
        return integrates;
    }

    public void setIntegrates(List<String> integrates) {
        this.integrates = integrates;
    }

}
