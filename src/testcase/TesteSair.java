package testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import page.MenuPage;

import common.TestCaseCommon;

public class TesteSair {
	
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
		TestCaseCommon.getDriver().quit();
	}
	
	 @Test
	  public void verificaAcessoMenuBotaoSair() throws Exception {
		  
			MenuPage SairApp = new MenuPage();
			SairApp.setObjetos();
			ArrayList<String> RetornoDeObjetos = SairApp.getObjetos();
			System.out.println(RetornoDeObjetos.get(0));
		    assertEquals("Sair", RetornoDeObjetos.get(0));
//		    SairApp.FecharBrowser();
		
	  }
}
