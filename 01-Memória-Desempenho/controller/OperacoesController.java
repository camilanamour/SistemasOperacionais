package controller;

public class OperacoesController {
	
	//Método Construtor
	public OperacoesController(){
		super(); //segue as operações da superclasse OBJECTS - toda classe tem as características
	}
	

	/* Tipo String é imutável (não muda nunca -- apenas ocupa outros espaços da memória <x += y>)
	 * sendo redereçada na memória (xy), fazendo um sobreescrita em (x) ocupando espaço na memória
	 * sem limpar.
	 */
	
	public void ConcatenaString(){
		String palavra = "";
		double tempoinicial = System.nanoTime(); //pega o clock do sistema e retorna *long ou double* (nanosegundos)
												 //System.currentTimeMillis(); milissegundos
		for(int i=0;i<32768;i++){
			palavra+="a";
		}
		
		double tempofinal = System.nanoTime();
		double tempototal = tempofinal - tempoinicial;
		
		//Segundos (10^-9)s
		tempototal = tempototal/Math.pow(10, 9);
		System.out.println("String ==> " + tempofinal + "s.");
	}
	
	
	//Buffer armazena sempre na mesma posição de memória temporária mutável (concatenado na posição da memória)
	public void ConcatenaBuffer(){
		StringBuffer buffer = new StringBuffer(); //apenas instância -- assim como inicializa a String
		double tempoinicial = System.nanoTime(); 
		
		for(int i=0;i<32768;i++){
			buffer.append("a"); //pega um valor e coloca no final do buffer -- pode ser uma variavel de qualquer tipo.
		}
		
		double tempofinal = System.nanoTime();
		double tempototal = tempofinal - tempoinicial;
		
		//Segundos (10^-9) para nanosegundos
		tempototal = tempototal /  Math.pow(10, 9);
		System.out.println("Buffer ==> " + tempofinal + "s.");	
	}
	
	//Recebe uma frase, divide em palavras
	public void DivideFrase(String frase){
		String[] vpalavras = frase.split(" "); //Quebra a frase quando há espaço, elimina o espaço e armazena na posição (segundo a caractéristica) 
		
		/*vpalavras.length -- repetindo a validação da finalização no for para ver o tamanho
		 * ou int tamanho = vpalavra.length; atribuindo a variavel na finalização
		 */
		
		
		for(String palavra: vpalavras){ //foreach - for (tipoDado variavel: vetor || coleção)
			System.out.println(palavra);
			
			/*Sobe o vetor, atribui a variável, depois apaga e vai para outro até acabar
			 * para cada (foreach) posição.
			 */
		}
	
	}
	
	/*Fazer uma aplicação Java em Eclipse que tenha uma operação que receba um vetor de 
	* 1000 posições e gere o tempo gasto para percorrer o vetor. Repetir para 10000 e 
	* 100000 posições. Responder com o tempo (em nS ou S) de cada operação. 

	* RESPOSTA
	* 1000 - 7800.0 nS. --> 7.6E-6s
	* 10000 - 107500.0 nS. --> 1.075E-4s
	* 100000- 845500.0 nS. --> 0.0084550s
	*/
	
	public void Exercicio(){
		
		//Exercício de tempo + ForEach
		double tempo = 0.0;
		int posicao = 100000;
		int vetor[] = new int [posicao];
		
		double tempoinicial = System.nanoTime();
		for(int n: vetor){
		}
		double tempofinal = System.nanoTime();
		
		tempo = tempofinal-tempoinicial;
		System.out.println("Tempo para percorrer é: " + tempo + "ns.");
		tempo = tempo / Math.pow(10, 9);
		System.out.println("Tempo para percorrer a posição [" + posicao + "] é: " + tempo + "s.");

	}
}
