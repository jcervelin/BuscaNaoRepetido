package br.com.sapato.buscanaorepetido;

public class BuscaMain {

	public static char firstChar (Stream input) {
		String str = input.getInput();
		//Itera os caracteres do input e popula a implementação do Stream
		for (int i = 0; i < str.length(); i++) {
			//Seta o contador para o Stream verificar se o caracter nesta posição não está sendo repetido
			input.setCounter(i);
			//Usa o método getNext para obter o próximo caracter a ser pesquisado
			input.setCharacter(input.getNext());
			
			//Por meio de regex verifica se o caracter da posição do contador não está sendo repetido.
			//Se não estiver ele será retornado.
			if (!input.hasNext()) {
				return input.getCharacter();
			}
		}
		//Caso a iteração não encontre nenhum caracter não repetido o método retorna vazio
		return ' ';
	}

	public static void main(String[] args) {
		
		//Executa o algoritmo de busca pelo primeiro caracter não repetido
		//Implementa o Stream e popula o input com valor provindo de argumento (args)
		char firstChar = firstChar(new StreamImpl(args[0]));
		
		//Imprime mensagem de acordo com o que for encontrado no input
		if (firstChar == ' '){
			System.out.println("Não há caracteres repetidos no stream");
		} else {
			System.out.println(firstChar);
		}
	}
}