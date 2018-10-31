package ifpb.dac.album;

import java.io.Serializable;

/**
 *
 * @author Amanda
 */
public class Album implements Serializable{

    private int id;
    private String nome;
    private int banda;
    private int anoLancamento;

    public Album() {
    }

    public Album(int id, String nome, int banda, int anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.anoLancamento = anoLancamento;
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

    public int getBanda() {
        return banda;
    }

    public void setBanda(int banda) {
        this.banda = banda;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoDeLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
