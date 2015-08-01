package br.com.sapato.buscanaorepetido;

public class BuscaMain {

	public static char firstChar (Stream input) {
		String str = input.getInput();
		//Itera os caracteres do input e popula a implementa��o do Stream
		for (int i = 0; i < str.length(); i++) {
			//Seta o contador para o Stream verificar se o caracter nesta posi��o n�o est� sendo repetido
			input.setCounter(i);
			//Usa o m�todo getNext para obter o pr�ximo caracter a ser pesquisado
			input.setCharacter(input.getNext());
			
			//Por meio de regex verifica se o caracter da posi��o do contador n�o est� sendo repetido.
			//Se n�o estiver ele ser� retornado.
			if (!input.hasNext()) {
				return input.getCharacter();
			}
		}
		//Caso a itera��o n�o encontre nenhum caracter n�o repetido o m�todo retorna vazio
		return ' ';
	}

	public static void main(String[] args) {
		
		//Executa o algoritmo de busca pelo primeiro caracter n�o repetido
		//Implementa o Stream e popula o input com valor provindo de argumento (args)
		char firstChar = firstChar(new StreamImpl(args[0]));
		
		//Imprime mensagem de acordo com o que for encontrado no input
		if (firstChar == ' '){
			System.out.println("N�o h� caracteres repetidos no stream");
		} else {
			System.out.println(firstChar);
		}
	}
}