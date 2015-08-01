package br.com.sapato.buscanaorepetido;

public class StreamImpl implements Stream{
	private String input;
	private int i;
	private char character;
	
	public StreamImpl(String input){
		this.input = input;
	}
	
	//Retorna o caracter de acordo com a variavel "i", que deve ser atualizada por um método de iteração
	public char getNext() {
		return input.charAt(i);
	}

	//Verifica se o caracter atual bate com algum outro caracter do stream utilizando regex
	public boolean hasNext() {
		return input.matches("(.*)" + character + "(.*)" + character + "(.*)");
	}

	public int getCounter() {
		return i;
	}

	public void setCounter(int i) {
		this.i = i;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

}
