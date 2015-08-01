package br.com.sapato.buscanaorepetido;

public interface Stream {
	public char getNext();
	public boolean hasNext();
	public String getInput();
	public void setCounter(int i);
	public void setCharacter(char character);	
	public char getCharacter();	
}
