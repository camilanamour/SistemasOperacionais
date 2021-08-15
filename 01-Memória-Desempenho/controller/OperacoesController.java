package controller;

public class OperacoesController {
	
	//M�todo Construtor
	public OperacoesController(){
		super(); //segue as opera��es da superclasse OBJECTS - toda classe tem as caracter�sticas
	}
	

	/* Tipo String � imut�vel (n�o muda nunca -- apenas ocupa outros espa�os da mem�ria <x += y>)
	 * sendo redere�ada na mem�ria (xy), fazendo um sobreescrita em (x) ocupando espa�o na mem�ria
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
	
	
	//Buffer armazena sempre na mesma posi��o de mem�ria tempor�ria mut�vel (concatenado na posi��o da mem�ria)
	public void ConcatenaBuffer(){
		StringBuffer buffer = new StringBuffer(); //apenas inst�ncia -- assim como inicializa a String
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
		String[] vpalavras = frase.split(" "); //Quebra a frase quando h� espa�o, elimina o espa�o e armazena na posi��o (segundo a caract�ristica) 
		
		/*vpalavras.length -- repetindo a valida��o da finaliza��o no for para ver o tamanho
		 * ou int tamanho = vpalavra.length; atribuindo a variavel na finaliza��o
		 */
		
		
		for(String palavra: vpalavras){ //foreach - for (tipoDado variavel: vetor || cole��o)
			System.out.println(palavra);
			
			/*Sobe o vetor, atribui a vari�vel, depois apaga e vai para outro at� acabar
			 * para cada (foreach) posi��o.
			 */
		}
	
	}
	
	/*Fazer uma aplica��o Java em Eclipse que tenha uma opera��o que receba um vetor de 
	* 1000 posi��es e gere o tempo gasto para percorrer o vetor. Repetir para 10000 e 
	* 100000 posi��es. Responder com o tempo (em nS ou S) de cada opera��o. 

	* RESPOSTA
	* 1000 - 7800.0 nS. --> 7.6E-6s
	* 10000 - 107500.0 nS. --> 1.075E-4s
	* 100000- 845500.0 nS. --> 0.0084550s
	*/
	
	public void Exercicio(){
		
		//Exerc�cio de tempo + ForEach
		double tempo = 0.0;
		int posicao = 100000;
		int vetor[] = new int [posicao];
		
		double tempoinicial = System.nanoTime();
		for(int n: vetor){
		}
		double tempofinal = System.nanoTime();
		
		tempo = tempofinal-tempoinicial;
		System.out.println("Tempo para percorrer �: " + tempo + "ns.");
		tempo = tempo / Math.pow(10, 9);
		System.out.println("Tempo para percorrer a posi��o [" + posicao + "] �: " + tempo + "s.");

	}
}
