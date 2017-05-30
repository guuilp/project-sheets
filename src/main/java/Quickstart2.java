import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import enums.Celula;
import enums.Planilha;

public class Quickstart2 {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Google Sheets API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            Quickstart2.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
        Sheets service = getSheetsService();
        
        processaUPInformes(service);

        processaUPContaCorrente(service);

        processaUPInvestimentos(service);

        processaUpBmf(service);

        processaUPCanaisDigitais(service);

        processaUPComercial(service);

        processaUPContabil(service);

        processaUPNovoCobranca(service);

        processaUPCredito(service);

        processaUPFinanceira(service);

        processaUpSpb(service);
        
        processaUltimaAtualizacao(service);
        
    }

	private static void processaUltimaAtualizacao(Sheets service) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        List<Object> versao = new ArrayList<>();
        List<List<Object>> ultimaAtualizacao = new ArrayList<>();

        versao.clear();
        versao.add("Última atualização: " + dtf.format(now));
        ultimaAtualizacao.add(versao);
        atualizaVersaoData(service, ultimaAtualizacao, Celula.ULTIMA_ATUALIZACAO);
	}

	private static void processaUPInformes(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataInformes = new ArrayList<>();
		List<List<Object>> versaoDataSdbanco = new ArrayList<>();
		List<List<Object>> versaoDataSca = new ArrayList<>();
		List<List<Object>> versaoDataCaptura = new ArrayList<>();
		List<List<Object>> versaoDataSec = new ArrayList<>();
		List<List<Object>> versaoDataGarantias = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataInformes.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdbanco.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSca.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataCaptura.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSec.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataGarantias.add(versaoData);

		atualizaVersaoData(service, versaoDataInformes, Celula.INFORMES);
		atualizaVersaoData(service, versaoDataSdbanco, Celula.SDBANCO);
		atualizaVersaoData(service, versaoDataSca, Celula.SCA);
		atualizaVersaoData(service, versaoDataCaptura, Celula.CAPTURA);
		atualizaVersaoData(service, versaoDataSec, Celula.SEC);
		atualizaVersaoData(service, versaoDataGarantias, Celula.GARANTIAS);
	}

	private static void processaUPContaCorrente(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataPandata = new ArrayList<>();
		List<List<Object>> versaoDataSdconta = new ArrayList<>();
		List<List<Object>> versaoDataFluxoDeCaixa = new ArrayList<>();
		List<List<Object>> versaoDataSdcompe = new ArrayList<>();
		List<List<Object>> versaoDataCartoes = new ArrayList<>();
		List<List<Object>> versaoDataSdtes = new ArrayList<>();
		List<List<Object>> versaoDataConvenios = new ArrayList<>();
		List<List<Object>> versaoDataVoltaspb = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataPandata.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdconta.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFluxoDeCaixa.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdcompe.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataCartoes.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdtes.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataConvenios.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataVoltaspb.add(versaoData);

		atualizaVersaoData(service, versaoDataPandata, Celula.PANDATA);
		atualizaVersaoData(service, versaoDataSdconta, Celula.SDCONTA);
		atualizaVersaoData(service, versaoDataFluxoDeCaixa, Celula.FLUXO_DE_CAIXA);
		atualizaVersaoData(service, versaoDataSdcompe, Celula.SDCOMPE);
		atualizaVersaoData(service, versaoDataCartoes, Celula.CARTOES);
		atualizaVersaoData(service, versaoDataSdtes, Celula.SDTES);
		atualizaVersaoData(service, versaoDataConvenios, Celula.CONVENIOS);
		atualizaVersaoData(service, versaoDataVoltaspb, Celula.VOLTASPB);
	}

	private static void processaUPInvestimentos(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataSdndf = new ArrayList<>();
		List<List<Object>> versaoDataSdopen = new ArrayList<>();
		List<List<Object>> versaoDataSdflex = new ArrayList<>();
		List<List<Object>> versaoDataSdswap = new ArrayList<>();
		List<List<Object>> versaoDataCcb = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdndf.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdopen.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdflex.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdswap.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataCcb.add(versaoData);

		atualizaVersaoData(service, versaoDataSdndf, Celula.SDNDF);
		atualizaVersaoData(service, versaoDataSdopen, Celula.SDOPEN);
		atualizaVersaoData(service, versaoDataSdflex, Celula.SDFLEX);
		atualizaVersaoData(service, versaoDataSdswap, Celula.SDSWAP);
		atualizaVersaoData(service, versaoDataCcb, Celula.CCB);
	}

	private static void processaUpBmf(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataBmf = new ArrayList<>();
		List<List<Object>> versaoDataRv = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataBmf.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataRv.add(versaoData);

		atualizaVersaoData(service, versaoDataBmf, Celula.BMF);
		atualizaVersaoData(service, versaoDataRv, Celula.RV);
	}

	private static void processaUPCanaisDigitais(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataEmailBanking = new ArrayList<>();
		List<List<Object>> versaoDataPortalMercedes = new ArrayList<>();
		List<List<Object>> versaoDataMeiosPgto = new ArrayList<>();
		List<List<Object>> versaoDataInternetBanking = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataEmailBanking.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataPortalMercedes.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataMeiosPgto.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataInternetBanking.add(versaoData);

		atualizaVersaoData(service, versaoDataEmailBanking, Celula.EMAIL_BANKING);
		atualizaVersaoData(service, versaoDataPortalMercedes, Celula.PORTAL_MERCEDES);
		atualizaVersaoData(service, versaoDataMeiosPgto, Celula.MEIOS_PGTO);
		atualizaVersaoData(service, versaoDataInternetBanking, Celula.INTERNET_BANKING);
	}

	private static void processaUPComercial(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataFincn = new ArrayList<>();
		List<List<Object>> versaoDataFinev = new ArrayList<>();
		List<List<Object>> versaoDataFingc = new ArrayList<>();
		List<List<Object>> versaoDataFinof = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFincn.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinev.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFingc.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinof.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();

		atualizaVersaoData(service, versaoDataFincn, Celula.FINCN);
		atualizaVersaoData(service, versaoDataFinev, Celula.FINEV);
		atualizaVersaoData(service, versaoDataFingc, Celula.FINGC);
		atualizaVersaoData(service, versaoDataFinof, Celula.FINOF);
	}

	private static void processaUPContabil(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataFinlf = new ArrayList<>();
		List<List<Object>> versaoDataFinlm = new ArrayList<>();
		List<List<Object>> versaoDataFinaf = new ArrayList<>();
		List<List<Object>> versaoDataFinct = new ArrayList<>();
		List<List<Object>> versaoDataGeracaoDsCp = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinlf.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinlm.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinaf.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinct.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataGeracaoDsCp.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();

		atualizaVersaoData(service, versaoDataFinlf, Celula.FINLF);
		atualizaVersaoData(service, versaoDataFinlm, Celula.FINLM);
		atualizaVersaoData(service, versaoDataFinaf, Celula.FINAF);
		atualizaVersaoData(service, versaoDataFinct, Celula.FINCT);
		atualizaVersaoData(service, versaoDataGeracaoDsCp, Celula.GERACAO_DS_CP);
	}

	private static void processaUPNovoCobranca(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataDda = new ArrayList<>();
		List<List<Object>> versaoDataSdcobr = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataDda.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdcobr.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();

		atualizaVersaoData(service, versaoDataDda, Celula.DDA);
		atualizaVersaoData(service, versaoDataSdcobr, Celula.SDCOBR);
	}

	private static void processaUPCredito(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataSdemp = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdemp.add(versaoData);

		atualizaVersaoData(service, versaoDataSdemp, Celula.SDEMP);
	}

	private static void processaUPFinanceira(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataAprovadorMobile = new ArrayList<>();
		List<List<Object>> versaoDataFincb = new ArrayList<>();
		List<List<Object>> versaoDataFinfn = new ArrayList<>();
		List<List<Object>> versaoDataFincr = new ArrayList<>();
		List<List<Object>> versaoDataPcx = new ArrayList<>();
		List<List<Object>> versaoDataFincp = new ArrayList<>();
		
		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataAprovadorMobile.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFincb.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFinfn.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFincr.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataPcx.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataFincp.add(versaoData);

		atualizaVersaoData(service, versaoDataAprovadorMobile, Celula.APROVADOR_MOBILE);
		atualizaVersaoData(service, versaoDataFincb, Celula.FINCB);
		atualizaVersaoData(service, versaoDataFinfn, Celula.FINFN);
		atualizaVersaoData(service, versaoDataFincr, Celula.FINCR);
		atualizaVersaoData(service, versaoDataPcx, Celula.PCX);
		atualizaVersaoData(service, versaoDataFincp, Celula.FINCP);
	}

	private static void processaUpSpb(Sheets service) throws IOException{
		List<Object> versaoData = new ArrayList<>();

		List<List<Object>> versaoDataIntegBradesco = new ArrayList<>();
		List<List<Object>> versaoDataIntegAsbcrk = new ArrayList<>();
		List<List<Object>> versaoDataIbkApis = new ArrayList<>();
		List<List<Object>> versaoDataINTEGCeM = new ArrayList<>();
		List<List<Object>> versaoDataPlf = new ArrayList<>();
		List<List<Object>> versaoDataGrade = new ArrayList<>();
		List<List<Object>> versaoDataMaterajud = new ArrayList<>();
		List<List<Object>> versaoDataSdspb = new ArrayList<>();
		List<List<Object>> versaoDataIntegAutbank = new ArrayList<>();
		List<List<Object>> versaoDataMateraccs = new ArrayList<>();
		List<List<Object>> versaoDataIntegMintter = new ArrayList<>();
		List<List<Object>> versaoDataConsole = new ArrayList<>();
		List<List<Object>> versaoDataIntegJdpsti = new ArrayList<>();

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIntegBradesco.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIntegAsbcrk.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIbkApis.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataINTEGCeM.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataPlf.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataGrade.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataMaterajud.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataSdspb.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIntegAutbank.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataMateraccs.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIntegMintter.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataConsole.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();
		versaoDataIntegJdpsti.add(versaoData);

		versaoData.clear();
		versaoData.add();
		versaoData.add();

		atualizaVersaoData(service, versaoDataIntegBradesco, Celula.INTEG_BRADESCO);
		atualizaVersaoData(service, versaoDataIntegAsbcrk, Celula.INTEG_ASBCRK);
		atualizaVersaoData(service, versaoDataIbkApis, Celula.IBK_APIS);
		atualizaVersaoData(service, versaoDataINTEGCeM, Celula.INTEG_CeM);
		atualizaVersaoData(service, versaoDataPlf, Celula.PLF);
		atualizaVersaoData(service, versaoDataGrade, Celula.GRADE);
		atualizaVersaoData(service, versaoDataMaterajud, Celula.MATERAJUD);
		atualizaVersaoData(service, versaoDataSdspb, Celula.SDSPB);
		atualizaVersaoData(service, versaoDataIntegAutbank, Celula.INTEG_AUTBANK);
		atualizaVersaoData(service, versaoDataMateraccs, Celula.MATERACCS);
		atualizaVersaoData(service, versaoDataIntegMintter, Celula.INTEG_MINTTER);
		atualizaVersaoData(service, versaoDataConsole, Celula.CONSOLE);
		atualizaVersaoData(service, versaoDataIntegJdpsti, Celula.INTEG_JDPSTI);
	}

	private static void atualizaVersaoData(Sheets service, List<List<Object>> versaoEData, Celula celula) throws IOException {
		service.spreadsheets()
			.values()
			.update(Planilha.ID.toString(), celula.toString(), new ValueRange().setValues(versaoEData))
			.setValueInputOption(Planilha.INPUT_OPTION.toString())
			.execute();
	}

}