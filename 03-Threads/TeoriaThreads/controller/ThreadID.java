package controller;

/* extends thread -- herda caracteristicas da Thread 
 * (botão direito>source>override implement methods)
 * passagem de parâmetros pelo contrustor
 * método run - para inicializar a execução da thread
 */

/* Essa thread é uma thread simples, chamando-a diversas vezes, várias 
 * threads com a mesma operação, rodando simultaneamente, pq são
 * independentes
 */

public class ThreadID extends Thread{ //agora a classe é uma thread
	
	private int idThread;
	
	//Método Construtor
	public ThreadID(int idThread){
		this.idThread = idThread;	
	}
	
	@Override
		public void run() {
//			Só executa o que está aqui dentro 
//			Quanto mais instruções, mais o ciclo de vida fica dependente do que 
//			está acontecendo e as últimas podem acabar antes, pois são independentes.
			int id = (int) getId();
			System.out.println("#ID (for): " + idThread + " | #TID: " + id);
		}

}
