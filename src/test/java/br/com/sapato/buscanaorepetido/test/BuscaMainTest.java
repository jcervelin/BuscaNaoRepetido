package br.com.sapato.buscanaorepetido.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import br.com.sapato.buscanaorepetido.BuscaMain;
import br.com.sapato.buscanaorepetido.Stream;
import br.com.sapato.buscanaorepetido.StreamImpl;

public class BuscaMainTest {

	private String inputUmCaracterNaoRepetido;
	private String inputDoisCaracteresNaoRepetidos;
	private String inputNenhumCaracterNaoRepetido;
	
	private Stream streamInputUmCaracterNaoRepetido;
	private Stream streamInputDoisCaracteresNaoRepetidos;
	private Stream streamInputNenhumCaracterNaoRepetido;
	
	//Inicializa objetos que ser�o usados no teste
	@Before
	public void init(){
		inputUmCaracterNaoRepetido = "vVVvHllAAabcabc";
		inputDoisCaracteresNaoRepetidos = "vVVvJllAAHabcabc";
		inputNenhumCaracterNaoRepetido = "vVVvllAAabcabc";
		streamInputUmCaracterNaoRepetido = new StreamImpl(inputUmCaracterNaoRepetido);
		streamInputDoisCaracteresNaoRepetidos = new StreamImpl(inputDoisCaracteresNaoRepetidos);
		streamInputNenhumCaracterNaoRepetido = new StreamImpl(inputNenhumCaracterNaoRepetido);
	}
	
	//Verifica se o metodo firstChar retorna 'H'. Que � o primeiro caracter n�o repetido do stream vVVvHllAAabcabc
	@Test
	public void firstCharInputUmCaracterNaoRepetido(){
		char first = BuscaMain.firstChar(streamInputUmCaracterNaoRepetido);
		assertEquals(first, 'H');
	}

	//Verifica se o metodo firstChar retorna 'J'. Que � o primeiro caracter n�o repetido do stream vVVvJllAAHabcabc
	//Tamb�m valida se o metodo est� realmente pegando o primeiro caracter repetido e n�o o �ltimo
	@Test
	public void firstCharInputDoisCaracteresNaoRepetidos(){
		char first = BuscaMain.firstChar(streamInputDoisCaracteresNaoRepetidos);
		assertEquals(first, 'J');
	}
	
	//Verifica se retorna vazio quando n�o existirem caracteres repetidos
	@Test
	public void firstCharInputNenhumCaracterNaoRepetido(){
		char first = BuscaMain.firstChar(streamInputNenhumCaracterNaoRepetido);
		assertEquals(first, ' ');
	}
	
	//Seta o System.out com uma instancia de ByteArrayOutputStream e compara se a mensagem de sa�da � o que se espera
	//No caso desse teste � o "H". Que � o primeiro caracter n�o repetido do input "vVVvHllAAabcabc"
	@Test
	public void mensagemMainTrue(){
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

		BuscaMain.main(new String[]{inputUmCaracterNaoRepetido});
		assertEquals("H", outContent.toString().trim());
	}

	//Seta o System.out com uma instancia de ByteArrayOutputStream e compara se a mensagem de sa�da � o que se espera
	//No caso desse teste � a mensagem amig�vel "N�o h� caracteres repetidos no stream". 
	//Pois o input inclu�do � "vVVvllAAabcabc" e nesse caso realmente nenhum caracter se repete
	@Test
	public void mensagemMainFalse(){
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

		BuscaMain.main(new String[]{inputNenhumCaracterNaoRepetido});
		assertEquals("N�o h� caracteres repetidos no stream", outContent.toString().trim());
	}
	
}