package testcase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.By;

import page.BuscarSuportesPage;
import page.MenuPage;
import page.PendenciasPage;
import page.TreinamentosPage;

import common.TestCaseCommon;

public class TestFull {


	private StringBuffer verificationErrors = new StringBuffer();


	@Before
	public void setUp() throws Exception {
			TestCaseCommon.getDriver().get(TestCaseCommon.URL_BASE + "/");
	}
	
  	
	@After
	public void tearDown() throws Exception {
		

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void buscaTreinamentoPorNome() throws Exception {
				
			MenuPage AbreTela = new MenuPage();
			AbreTela.AbreTelaTreinamento();
//		Thread.sleep(20000);
			TreinamentosPage NovaBusca = new TreinamentosPage(); 
			String retorno = NovaBusca.BuscarTreinamento("Roberto");
			assertThat("0", is(not(retorno))); 
	}
	
		
	  @Test
	  public void expandirSuportePendente() throws Exception {
		  
		  MenuPage TelaPendencias = new MenuPage();
		TelaPendencias.AbreTelaPendencias();
			
		  PendenciasPage ExpandirSuporte = new PendenciasPage();
		  String RetornoDeClick = ExpandirSuporte.ExpandirTreinamentoPendente();
		  assertEquals("Produto", RetornoDeClick );
	  }
	  
		@Test
		public void buscaSuportePorNomeDeUsuario() throws Exception {

			MenuPage TelaMenu = new MenuPage();
			TelaMenu.AbreTelaBuscarSuportes();
			
			BuscarSuportesPage BuscarSuporte = new BuscarSuportesPage();
			String retorno = BuscarSuporte.BuscarTreinamentoPorNomeDelio();
			assertThat("0", is(not(retorno))); 
			
		}
			
		 @Test
		  public void testVerificaElementosAoIniciar() throws Exception {
			  
				MenuPage VerificarElementos = new MenuPage();
				VerificarElementos.setObjetos();

				ArrayList<String> RetornoDeObjetos = VerificarElementos.getObjetos();
			    System.out.println(RetornoDeObjetos.get(0));
				assertEquals("Sair", RetornoDeObjetos.get(0));
				assertEquals("Estatísticas", RetornoDeObjetos.get(1));
				assertEquals("Elipse Care", RetornoDeObjetos.get(2));
				assertEquals("Treinamentos", RetornoDeObjetos.get(3));
				assertEquals("E-mails Treinamento", RetornoDeObjetos.get(4));
}	

		  @Test
		  public void verificaAcessoMenuDisponibilidadeDeUsuario() throws Exception {
			  
				MenuPage AdminPage = new MenuPage();
				AdminPage.AbreTelaConfiguracoes();
				assertEquals("Admin", AdminPage.verificaAcessoAdmin());

				System.out.println(AdminPage.verificaAcessoAdmin());
				AdminPage.AbreTelaAdmin();
				
		  }
		 
}
