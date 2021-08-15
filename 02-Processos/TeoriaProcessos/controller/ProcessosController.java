package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	
	public ProcessosController(){
		super();
	}
	
//	Retorne o Sistema Operacional que est� em execu��o na m�quina
	public String os(){
		String os = System.getProperty("os.name"); //retorna o nome do S.O (key-String-saber)
		String arch = System.getProperty("os.arch"); //retorna arquitetura (arch- 64 ou 32 bits)
		String version = System.getProperty("os.version"); //retorna vers�o (version)
		return "Nome: " + os + " - vers�o: " + version + " - Arquitetura: " + arch; //retorna tudo o que deseja
	}
	
	
//	Um processo chama outro processo
	public void chamaProcesso(String processo){		
		try {
			Runtime.getRuntime().exec(processo);
		} catch (Exception e) {
//			e.printStackTrace(); print do erro no console 
			String msgErro = e.getMessage(); //retorna apenas a primeira linha -- ERRO 740
//			System.err.println(msgErro); mensagem em vermelho
			
			if(msgErro.contains("740")){ //uma parte -- <ctrl + shift + i> mostra o resultado l�gico
				StringBuffer buffer = new StringBuffer();
//				cmd /c caminho_do_processo -- para validar a solicita��o de administrador
				buffer.append("cmd /c"); 
				buffer.append(" ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString()); //n�o aceita buffer
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			} else{
				e.printStackTrace(); //print do erro no console ou System.err.println(msgErro)
			}
		}
	}
	
	//Leitura de processos
	public void lerProcesso(String processo){
		try {
			Process p = Runtime.getRuntime().exec(processo); 	//Tipo processo - com os dados do processo filho (processo chamado)
//			todos os dados que o processo acima executar a v�riavel ir� armazenar uma aplica��o infinita ou r�pida.
			
			InputStream fluxo = p.getInputStream();		//retorna um inputStream -- fluxo de bits
			InputStreamReader leitor = new InputStreamReader(fluxo); 	//l� fluxo e converte para String -- processo sa�da de console
//			Bufferizar para n�o estourar a mem�ria o que � convertido
			BufferedReader buffer = new BufferedReader(leitor); 	//guarda no buffer a convers�o
			
			String linha = buffer.readLine(); // l� a primeira linha do buffer; pr�xima; descarta; sucessivamente
			while(linha != null){
				System.out.println(linha); //fazer o tratamento que quiser -- split..
				linha = buffer.readLine();
			} // at� terminar
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Matar o processo pelo PID ou pelo Nome dele (n�o recomendavel -- nome)
	public void mataProcesso(String parametro){
		//WINDOWS
		String cmdPid = "TASKKILL /PID"; //�nico e n�merico
		String cmdNome = "TASKKILL /IM"; //repetido e pode ter n�mero ou n�o
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		//NumberFormatException (possibilidade)
		try{
			//TASKKILL /PID qlqrn�mero
			pid = Integer.parseInt(parametro); //matar pelo pid -- converte o parametro para n�mero
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		}catch(NumberFormatException e){
			//TASKKILL /IM nomedoprocesso.exe
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(parametro); //String
		}
		chamaProcesso(buffer.toString());
		
	}
}
