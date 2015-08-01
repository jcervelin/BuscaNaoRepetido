# BuscaNaoRepetido

A aplicação tem como objetivo encontrar o primeiro caracter não repetido, a partir de uma string.

Foi criado um jar com uma classe main para executar via linha de comando. O input entra como um argumento

Ex. de execução:
java -cp BuscaNaoRepetido-0-0-1-SNAPSHOT.jar br.com.sapato.buscanaorepetido.BuscaMain DcaarDZzzZ

DcaarDZzzZ é o input

O resultado esperado para este exemplo é "c". Pois seria o primeiro caracter não repetido.

Para fazer a busca foi utilizado um método regex  "hasNext" que recebe um caracter e o input.
Se esse caracter tiver mais de uma ocorrência o retorno será verdadeiro.
Caso contrário significa que o caracter foi encontrado.

Este método é iterado com cada caracter do input. E assim que receber um FALSE, ou seja, 
não houver um próximo, a busca terá terminado.

A lógica seria essa:

input.matches("(.*)c(.*)c(.*)");

Em que "c" seria nosso caracter buscado.
Verifica se o input bate com o regex "(.*)" + character + "(.*)" + character + "(.*)"
Em que character seria igual a "c"
Se dentro de input existir qualquer caracter antes ou depois de um "c" seguido de outro "c" 
o resultado será verdadeiro. 

No caso de DcaarDZzzZ seria falso. Pois só há uma ocorrencia e não bate com o regex.

#Arquitetura

* Linguagem Java;
* Arquivo jar, que pode ser executado por um arquivo bat, ferramentas como CONTROL-M e linha de comando.
* O código está todo comentado com explicações e passo a passo da lógica utilizada;
* Foi utilizado JUNIT para criar casos de teste para diversos cenários, tanto de sucesso quanto de falha;
* Foi utilizado Maven para controle de dependências, executar todos os casos de teste do JUNIT e gerar o arquivo jar;
