package br.com.sapato.buscanaorepetido.test;

import org.junit.Before;
import org.junit.Test;

import br.com.sapato.buscanaorepetido.Stream;
import br.com.sapato.buscanaorepetido.StreamImpl;

import static org.junit.Assert.*;

public class StreamTest {

	private String input;
	private Stream stream;
	
	//Inicializa objetos que serão usados no teste
	@Before
	public void init(){
		input = "vVVvHllAAabcabc";
		stream = new StreamImpl(input);
	}
	
	//Verifica se o método getNext está retornando o próximo caracter
	//Neste caso, como o counter não foi incrementado ainda o correto seria retornar 'v'.
	//Pois o counter está com 0 e o registro na posição 0 do input vVVvHllAAabcabc é o caracter acima sitado.
	@Test
	public void getNextSucessoTest(){
		char atual = stream.getNext();
		assertEquals('v', atual);
	}

	//Verifica se o método getNext está retornando o próximo caracter
	//Neste caso, como o counter foi setado com valor 1, o correto seria retornar 'V'.
	//E o registro na posição 1 do input vVVvHllAAabcabc é o caracter acima sitado.
	//Na validação abaixo é verificado se é diferente do valor 0.
	//Mas surtiria o mesmo efeito se fosse comparado com 'V'
	@Test
	public void getNextFalhaTest(){
		stream.setCounter(1);
		char atual = stream.getNext();
		assertNotSame('v', atual);
	}

	//Verifica se o caracter 'H' está sendo repetido no input "vVVvHllAAabcabc"
	//Neste caso não está. Então o correto seria o método hasNext retornar FALSO.
	//Pois não há mais nada a ser processado, visto que o primeiro caracter 
	//não repetido já foi encontrado
	@Test
	public void hasNextFalseTest(){
		stream.setCharacter('H');
		boolean atual = stream.hasNext();
		assertFalse(atual);
	}

	//Verifica se o caracter 'v' está sendo repetido no input "vVVvHllAAabcabc"
	//Neste caso está. Então o correto seria o método hasNext retornar TRUE.
	@Test
	public void hasNextTrueTest(){
		stream.setCharacter('v');
		boolean atual = stream.hasNext();
		assertTrue(atual);
	}
}