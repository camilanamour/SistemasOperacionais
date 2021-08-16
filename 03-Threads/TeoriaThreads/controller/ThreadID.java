package controller;

/* extends thread -- herda caracteristicas da Thread 
 * (bot�o direito>source>override implement methods)
 * passagem de par�metros pelo contrustor
 * m�todo run - para inicializar a execu��o da thread
 */

/* Essa thread � uma thread simples, chamando-a diversas vezes, v�rias 
 * threads com a mesma opera��o, rodando simultaneamente, pq s�o
 * independentes
 */

public class ThreadID extends Thread{ //agora a classe � uma thread
	
	private int idThread;
	
	//M�todo Construtor
	public ThreadID(int idThread){
		this.idThread = idThread;	
	}
	
	@Override
		public void run() {
//			S� executa o que est� aqui dentro 
//			Quanto mais instru��es, mais o ciclo de vida fica dependente do que 
//			est� acontecendo e as �ltimas podem acabar antes, pois s�o independentes.
			int id = (int) getId();
			System.out.println("#ID (for): " + idThread + " | #TID: " + id);
		}

}
