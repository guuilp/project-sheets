package enums;

public enum Planilha {
    ID("1elZcOV56qmF-ZPm1xIstKzk9zwAoUMfQvuQCVx1u_RE"),
    INPUT_OPTION("RAW");

    private final String planilha;

    private Planilha(final String planilha) {
        this.planilha = planilha;
    }

    @Override
    public String toString() {
        return planilha;
    }
}
