package br.com.sapato.buscanaorepetido.test;

import org.junit.Before;
import org.junit.Test;

import br.com.sapato.buscanaorepetido.Stream;
import br.com.sapato.buscanaorepetido.StreamImpl;

import static org.junit.Assert.*;

public class StreamTest {

	private String input;
	private Stream stream;
	
	//Inicializa objetos que ser�o usados no teste
	@Before
	public void init(){
		input = "vVVvHllAAabcabc";
		stream = new StreamImpl(input);
	}
	
	//Verifica se o m�todo getNext est� retornando o pr�ximo caracter
	//Neste caso, como o counter n�o foi incrementado ainda o correto seria retornar 'v'.
	//Pois o counter est� com 0 e o registro na posi��o 0 do input vVVvHllAAabcabc � o caracter acima sitado.
	@Test
	public void getNextSucessoTest(){
		char atual = stream.getNext();
		assertEquals('v', atual);
	}

	//Verifica se o m�todo getNext est� retornando o pr�ximo caracter
	//Neste caso, como o counter foi setado com valor 1, o correto seria retornar 'V'.
	//E o registro na posi��o 1 do input vVVvHllAAabcabc � o caracter acima sitado.
	//Na valida��o abaixo � verificado se � diferente do valor 0.
	//Mas surtiria o mesmo efeito se fosse comparado com 'V'
	@Test
	public void getNextFalhaTest(){
		stream.setCounter(1);
		char atual = stream.getNext();
		assertNotSame('v', atual);
	}

	//Verifica se o caracter 'H' est� sendo repetido no input "vVVvHllAAabcabc"
	//Neste caso n�o est�. Ent�o o correto seria o m�todo hasNext retornar FALSO.
	//Pois n�o h� mais nada a ser processado, visto que o primeiro caracter 
	//n�o repetido j� foi encontrado
	@Test
	public void hasNextFalseTest(){
		stream.setCharacter('H');
		boolean atual = stream.hasNext();
		assertFalse(atual);
	}

	//Verifica se o caracter 'v' est� sendo repetido no input "vVVvHllAAabcabc"
	//Neste caso est�. Ent�o o correto seria o m�todo hasNext retornar TRUE.
	@Test
	public void hasNextTrueTest(){
		stream.setCharacter('v');
		boolean atual = stream.hasNext();
		assertTrue(atual);
	}
}