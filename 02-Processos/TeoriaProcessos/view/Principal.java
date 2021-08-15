package view;

import controller.ProcessosController;
//<ctrl + shift + o> corrige imports (acrecenta ou retira)

public class Principal {
	/* PROCESSOS
	 * 1) Processo chama outro
	 * 2) Processo mata outro
	 * 3) Processo se comunica com outro processo e l� o que ele est� gerando
	 */
	
	public static void main(String[] args) {
		ProcessosController controle = new ProcessosController();
		
// INFORMA��ES DO SISTEMA OPERACIONAL
		String info = controle.os();
		System.out.println(info); //nome, vers�o, arquitetura		
		
/* INICIAR PROCESSO
 * 		String processo = "C:\\Windows\\write.exe"; //(torna processo filho)- caminho at� o executavel qlqr (Windows e Linux)
 * 		C:\\Windows\\write.exe
 * 		C:\\Windows\\regedit.exe (erro 740 - administrador) - no Windows(na aula) e no Linux (formas diferentes entre Linux)
 * 		controle.chamaProcesso(processo);
 */
		
/* LER PROCESSO
 * 		String processo = "TASKLIST /FO TABLE"; 
 * 		TASKLIST /FO TABLE -- L� gerenciador de processos
 * 		PING -t10 www.google.com.br ==> calcular o tempo de resposta -- colocar num vetor num split (" ") e calcular o tempo split de ("=") na posi��o 2
 * 		TRACERT www.uol.com.br ==> rota da rede para o site
 * 		ipconfig ==> rede
 * 		controle.lerProcesso(processo);
 */
		
/* MATAR PROCESSO	
 *  	String parametro = "39056";
 *  	cmd.exe ==> catch
 *  	n�mero ==> try
 *  	controle.mataProcesso(parametro); 
 */
		
	}
	
}

/* COMENT�RIOS - ENSINOS
 * - Obs. Cada S.O tem sua sintaxe propria (criar metodos espec�ficos em cada S.O)
 * - Obs. Para valer uma barra no comando do terminal precisa colocar duas barras (\\)
	
 *-> bloco try...catch
 *   try{
	 		todas as linhas que quero que receba tratamento 
			linha 1 deu certo passa para a pr�xima; linha 2 deu certo passa para a pr�xima; ...
			sen�o - guarda todas as linhas de exce��o na v�riavel "e"
		
	}catch (Exception e){  		//classe - tratando generica ou espec�fica (uma ou mais de uma exception)
			linhas de tratamento do erro; mostrar o erro, tentar outros comandos.
	}
	
 *-> ProcessBulder -- administrador
	*/

