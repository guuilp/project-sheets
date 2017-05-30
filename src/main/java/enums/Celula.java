package enums;

public enum Celula {
	//UP Informes
	INFORMES(Planilha.ABA.toString() + "!B3:C3"),
	SDBANCO(Planilha.ABA.toString() + "!B4:C4"),
	SCA(Planilha.ABA.toString() + "!B5:C5"),
	CAPTURA(Planilha.ABA.toString() + "!B6:C6"),
	SEC(Planilha.ABA.toString() + "!B7:C7"),
	GARANTIAS(Planilha.ABA.toString() + "!B8:C8"),

	//UP Conta Corrente
	PANDATA(Planilha.ABA.toString() + "!B12:C12"),
	SDCONTA(Planilha.ABA.toString() + "!B13:C13"),
	FLUXO_DE_CAIXA(Planilha.ABA.toString() + "!B14:C14"),
	SDCOMPE(Planilha.ABA.toString() + "!B15:C15"),
	CARTOES(Planilha.ABA.toString() + "!B16:C16"),
	SDTES(Planilha.ABA.toString() + "!B17:C17"),
	CONVENIOS(Planilha.ABA.toString() + "!B18:C18"),
	VOLTASPB(Planilha.ABA.toString() + "!B19:C19"),

	//UP Investimentos
	SDNDF(Planilha.ABA.toString() + "!B23:C23"),
	SDOPEN(Planilha.ABA.toString() + "!B24:C24"),
	SDFLEX(Planilha.ABA.toString() + "!B25:C25"),
	SDSWAP(Planilha.ABA.toString() + "!B26:C26"),
	CCB(Planilha.ABA.toString() + "!B27:C27"),

	//UP BMF
	BMF(Planilha.ABA.toString() + "!B30:C30"),
	RV(Planilha.ABA.toString() + "!B31:C31"),

	//UP Canais Digitais
	EMAIL_BANKING(Planilha.ABA.toString() + "!F3:G3"),
	PORTAL_MERCEDES(Planilha.ABA.toString() + "!F4:G4"),
	MEIOS_PGTO(Planilha.ABA.toString() + "!F5:G5"),
	INTERNET_BANKING(Planilha.ABA.toString() + "!F6:G6"),

	//UP Comercial
	FINCN(Planilha.ABA.toString() + "!F10:G10"),
	FINEV(Planilha.ABA.toString() + "!F11:G11"),
	FINGC(Planilha.ABA.toString() + "!F12:G12"),
	FINOF(Planilha.ABA.toString() + "!F13:G13"),

	//UP Contábil
	FINLF(Planilha.ABA.toString() + "!F17:G17"),
	FINLM(Planilha.ABA.toString() + "!F18:G18"),
	FINAF(Planilha.ABA.toString() + "!F19:G19"),
	FINCT(Planilha.ABA.toString() + "!F20:G20"),
	GERACAO_DS_CP(Planilha.ABA.toString() + "!F21:G21"),

	//UP Novo Cobrança
	DDA(Planilha.ABA.toString() + "!F25:G25"),
	SDCOBR(Planilha.ABA.toString() + "!F26:G26"),

	//UP Crédito
	SDEMP(Planilha.ABA.toString() + "!J10:K10"),

	//UP Financeira
	APROVADOR_MOBILE(Planilha.ABA.toString() + "!J14:K14"),
	FINCB(Planilha.ABA.toString() + "!J15:K15"),
	FINFN(Planilha.ABA.toString() + "!J16:K16"),
	FINCR(Planilha.ABA.toString() + "!J17:K17"),
	PCX(Planilha.ABA.toString() + "!J18:K18"),
	FINCP(Planilha.ABA.toString() + "!J19:K19"),

	//UP SPB
	INTEG_BRADESCO(Planilha.ABA.toString() + "!J23:K23"),
	INTEG_ASBCRK(Planilha.ABA.toString() + "!J24:K24"),
	IBK_APIS(Planilha.ABA.toString() + "!J25:K25"),
	INTEG_CeM(Planilha.ABA.toString() + "!J26:K26"),
	PLF(Planilha.ABA.toString() + "!J27:K27"),
	GRADE(Planilha.ABA.toString() + "!J28:K28"),
	MATERAJUD(Planilha.ABA.toString() + "!J29:K29"),
	SDSPB(Planilha.ABA.toString() + "!J30:K30"),
	INTEG_AUTBANK(Planilha.ABA.toString() + "!J31:K31"),
	MATERACCS(Planilha.ABA.toString() + "!J32:K32"),
	INTEG_MINTTER(Planilha.ABA.toString() + "!J33:K33"),
	CONSOLE(Planilha.ABA.toString() + "!J34:K34"),
	INTEG_JDPSTI(Planilha.ABA.toString() + "!J35:K35"),
	
	ULTIMA_ATUALIZACAO(Planilha.ABA.toString() + "!M1:M1");

    private final String celula;

    private Celula(final String celula) {
        this.celula = celula;
    }

    @Override
    public String toString() {
        return celula;
    }
}
