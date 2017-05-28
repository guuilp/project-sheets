package enums;

public enum Celula {
    INFORMES("Sheet1!B3:C3"),
    SDBANCO("Sheet1!B4:C4"),
    SCA("Sheet1!B5:C5"),
    CAPTURA("Sheet1!B6:C6"),
    ULTIMA_ATUALIZACAO("Sheet1!A26:A26");

    private final String celula;

    private Celula(final String celula) {
        this.celula = celula;
    }

    @Override
    public String toString() {
        return celula;
    }
}
