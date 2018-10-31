package ifpb.dac.banda;

/**
 *
 * @author Amanda
 */
public enum Estilo {
    Rock("Rock"),
    Pop("Pop"),
    Sertanejo("Sertanejo"),
    KPop("KSPop");

    private String estilo;

    Estilo(String estilo) {
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }
}
